package com.hocelot.interview.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccDenRequest {

    private String clientOperationId;
    private String traceId;
    private String clientName;

    private String fullName;
    private String documentType;
    private String documentNumber;


}