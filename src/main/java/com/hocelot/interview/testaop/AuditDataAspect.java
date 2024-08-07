package com.hocelot.interview.testaop;

import com.hocelot.interview.clients.AuditDataClient;
import com.hocelot.interview.dto.AccDenRequest;
import com.hocelot.interview.dto.ScoreResponse;
import com.hocelot.interview.dto.InterviewTestRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Aspect
@Component
@Slf4j
public class AuditDataAspect {

    @Autowired
    private AuditDataClient auditDataClient;

    @Value("${mx.hocelot.api.validations.curp-pattern}")
    private String curpRegExp;

    @Around("@annotation(com.hocelot.interview.testaop.AuditData)")
    public Object audit(ProceedingJoinPoint joinPoint) throws Throwable {
        ScoreResponse scoreResponse = null;
        String countryCode, clientId;
        InterviewTestRequest interviewTestRequest;

        clientId = (String) joinPoint.getArgs()[1];
        interviewTestRequest = (InterviewTestRequest) joinPoint.getArgs()[2];
        scoreResponse = (ScoreResponse) joinPoint.proceed();

        String documentType = Pattern.compile(curpRegExp)
                .matcher(interviewTestRequest.getPerData().getDocumentNumber()).matches() ?
                "CURP" : "RFC";


        AccDenRequest accDenRequest = AccDenRequest.builder()
                .fullName(interviewTestRequest.getPerData().getFullname())
                .documentType(documentType)
                .documentNumber(interviewTestRequest.getPerData().getDocumentNumber())
                .build();

        ResponseEntity<Void> responseEntity = auditDataClient.auditAcceptedDeniedRequest(accDenRequest);
        if(responseEntity.getStatusCode().isError())
            throw new RuntimeException("....");
        return scoreResponse;
    }


}
