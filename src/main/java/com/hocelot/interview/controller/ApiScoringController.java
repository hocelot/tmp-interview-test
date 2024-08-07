package com.hocelot.interview.controller;

import com.hocelot.interview.dto.ScoreResponse;
import com.hocelot.interview.dto.InterviewTestRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


public interface ApiScoringController {

    ResponseEntity<ScoreResponse> getScore(@RequestHeader("HEADER_COUNTRY_CODE") final String countryCode,
                                           @RequestHeader("HEADER_USER_ID") final String userId,
                                           @RequestBody final InterviewTestRequest request,
                                           @RequestParam(required = false) final boolean isDebugData);

}
