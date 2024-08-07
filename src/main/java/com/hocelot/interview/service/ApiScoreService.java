package com.hocelot.interview.service;

import com.hocelot.interview.dto.ScoreResponse;
import com.hocelot.interview.dto.InterviewTestRequest;

public interface ApiScoreService {

    ScoreResponse callScoreService(String countryCode, String userId, InterviewTestRequest interviewTestRequest, final boolean isDebugData);
}
