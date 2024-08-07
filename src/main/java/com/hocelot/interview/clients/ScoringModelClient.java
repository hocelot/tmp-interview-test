package com.hocelot.interview.clients;

import com.hocelot.interview.dto.ScorModRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
    name = "${mx.hocelot.api.score.model.name}",
    decode404 = true
)
public interface ScoringModelClient {

    @PostMapping(
        path = "${mx.hocelot.api.score.model.endpoint}",
        consumes = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE},
        produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE}
    )
    ResponseEntity<BigDecimal> getScore(@RequestBody List<ScorModRequest> list);

}