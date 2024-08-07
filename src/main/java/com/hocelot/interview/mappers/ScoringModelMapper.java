package com.hocelot.interview.mappers;

import com.hocelot.interview.dto.InterviewTestRequest;
import com.hocelot.interview.dto.ScorModRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ScoringModelMapper {

    private String appName;


    public List<ScorModRequest> map(final InterviewTestRequest interviewTestRequest, final Object response) {

        final List<ScorModRequest> scorModRequestList = new ArrayList<>();
        ScorModRequest scorModRequest = new ScorModRequest();

        scorModRequestList.add(scorModRequest);
        return scorModRequestList;
    }

}
