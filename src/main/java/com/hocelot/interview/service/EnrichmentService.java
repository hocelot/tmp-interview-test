package com.hocelot.interview.service;

import com.hocelot.interview.dto.InterviewTestRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class EnrichmentService {

    public static final int MAX_TRIES = 3;

    private String tokenEndpoint;

    private String base64Credentials;

    private String enrichmentEndpoint;


    private final RestTemplate restTemplate;

    @Autowired
    public EnrichmentService(
		@Qualifier("simpleRestemplate") RestTemplate restTemplate,
		@Value("${mx.hocelot.api.score.enrichment.tokenEndpoint}") String tokenEndpoint,
		@Value("${mx.hocelot.api.score.enrichment.base64Credentials}") String base64Credentials,
	    @Value("${mx.hocelot.api.score.enrichment.enrichmentEndpoint}") String enrichmentEndpoint
	) {
        this.restTemplate = restTemplate;
        this.tokenEndpoint = tokenEndpoint;
        this.base64Credentials = base64Credentials;
        this.enrichmentEndpoint = enrichmentEndpoint;
    }

    public Object invokeEnrichment(String countryCode, InterviewTestRequest request) {
        ResponseEntity<Object> responseEntity = null;

        responseEntity = restTemplate.exchange(enrichmentEndpoint, HttpMethod.POST, new HttpEntity<>(request, getEnrichmentHeaders(countryCode)), Object.class);

        return responseEntity.getBody();
    }

    private HttpHeaders getEnrichmentHeaders(String countryCode) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(null);
        headers.set("HEADER_COUNTRY_CODE", countryCode);
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

}
