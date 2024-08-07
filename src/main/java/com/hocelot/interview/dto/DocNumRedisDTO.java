package com.hocelot.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DocNumRedisDTO implements Serializable {


    private String documentNumber;

    private LocalDateTime creationDate;
    private int counter;

    private boolean blockRequest;

}
