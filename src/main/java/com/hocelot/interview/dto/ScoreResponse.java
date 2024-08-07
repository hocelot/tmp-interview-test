package com.hocelot.interview.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode
public class ScoreResponse {

    private String operationId;

    @JsonIgnore
    private BigDecimal score;

    private Decission decission;

    private String traceId;

}
