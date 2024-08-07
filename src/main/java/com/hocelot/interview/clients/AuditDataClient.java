package com.hocelot.interview.clients;

import com.hocelot.interview.dto.AccDenRequest;
import com.hocelot.interview.dto.AudForRequest;
import com.hocelot.interview.dto.AudForResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@FeignClient(
        name = "${mx.hocelot.api.score.audit-data.name}",
        decode404 = true
)
public interface AuditDataClient {

    @PostMapping(
            path = "${mx.hocelot.api.score.audit-data.endpoint-request-response}",
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE}
    )
    ResponseEntity<Void> auditAcceptedDeniedRequest(
            @RequestBody AccDenRequest accDenRequest
    );

    @GetMapping(
            value = "/audit/checkNumberRequestByCurp",
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE}
    )
    ResponseEntity<Boolean> checkNumberRequestByCurp(@RequestParam(value = "documentNumber") String documentNumber);

    @PostMapping(
            path = "${mx.hocelot.api.score.audit-data.find-request}",
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE}
    )
    ResponseEntity<AudForResponse> auditFindRequest(
            @RequestBody AudForRequest audForRequest
    );
}
