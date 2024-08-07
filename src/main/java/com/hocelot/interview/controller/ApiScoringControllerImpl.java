package com.hocelot.interview.controller;

import com.hocelot.interview.dto.InterviewTestRequest;
import com.hocelot.interview.dto.ScoreResponse;
import com.hocelot.interview.service.ApiScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/test")
public class ApiScoringControllerImpl implements ApiScoringController {

    @Autowired
    private ApiScoreService apiScoreService;



    @PostMapping(
            value = "/test/score",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    @Override
    public ResponseEntity<ScoreResponse> getScore(@RequestHeader("HEADER_COUNTRY_CODE") final String countryCode,
                                                  @RequestHeader("HEADER_USER_ID") final String userId,
                                                  @RequestBody @Valid final InterviewTestRequest request,
                                                  @RequestParam(required = false) final boolean isDebugData) {

        return ResponseEntity.ok(apiScoreService.callScoreService(countryCode, userId, request, isDebugData));
    }

}
