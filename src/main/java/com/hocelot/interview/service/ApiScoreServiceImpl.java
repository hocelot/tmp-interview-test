package com.hocelot.interview.service;

import com.hocelot.interview.testaop.AuditData;
import com.hocelot.interview.clients.AuditDataClient;
import com.hocelot.interview.clients.ScoringModelClient;
import com.hocelot.interview.mappers.ScoringModelMapper;
import com.hocelot.interview.dto.ScoreResponse;
import com.hocelot.interview.dto.InterviewTestRequest;
import com.hocelot.interview.dto.ScorModRequest;
import com.hocelot.interview.dto.DocNumRedisDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class ApiScoreServiceImpl implements ApiScoreService {

    @Autowired
    private EnrichmentService enrichmentService;

    @Autowired
    private ScoringModelMapper scoringModelMapper;

    @Autowired
    private ScoringModelClient scoringModelClient;

    @Autowired
    private AuditDataClient auditDataClient;

    @Value("${mx.hocelot.api.validations.curp-pattern}")
    private String curpRegExp;


    @Value("${mx.hocelot.api.score.model.score}")
    private BigDecimal score;

    /*@Autowired
    private Tracer tracer;*/

    @Value("${mx.hocelot.api.validations.maxDocumentNumber}")
    private Integer maxDocumentNumber;

    @Value("${mx.hocelot.api.validations.cma1:true}")
    private Boolean cma1;


    @AuditData
    @Override
    public ScoreResponse callScoreService(String countryCode, String userId, InterviewTestRequest interviewTestRequest, final boolean isDebugData) {
        ScoreResponse scoreResponse = new ScoreResponse();

        DocNumRedisDTO dnRequest = new DocNumRedisDTO();//redisService.saveDocumentNumber(interviewTestRequest.getPerData().getDocumentNumber());
        if (dnRequest.getCounter() > maxDocumentNumber)
            //throw new TooManyRequestException("Too Many Request for documentNumber: " + interviewTestRequest.getPerData().getDocumentNumber(), null);
            throw new RuntimeException();

        if(cma1)
            System.out.println("");

        Object enrichmentResponse = enrichmentService.invokeEnrichment(countryCode, interviewTestRequest);


        callScoringModel(interviewTestRequest, enrichmentResponse, scoreResponse);

        return scoreResponse;
    }


    private ScoreResponse callScoringModel(InterviewTestRequest interviewTestRequest, Object enrichmentResponse, ScoreResponse scoreResponse) {
        List<ScorModRequest> modelRequest = new LinkedList<>();
        try {
            modelRequest = scoringModelMapper.map(interviewTestRequest, enrichmentResponse);


            //log.debug("Call dto with: "+ new GsonBuilder().setPrettyPrinting().create().toJson(modelRequest));
            BigDecimal modelResponse = scoringModelClient.getScore(modelRequest).getBody();


        } catch (Exception e) {
            log.error(" -> Generic Exception: {}", e.getMessage());
            throw new RuntimeException("Error invoking dto");
        }

        return scoreResponse;
    }

}
