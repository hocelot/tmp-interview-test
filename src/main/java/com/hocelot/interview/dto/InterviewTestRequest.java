package com.hocelot.interview.dto;

import com.hocelot.interview.valon.CuTestVaon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@CuTestVaon
@ApiModel(description = "InterviewTestRequest")
public class InterviewTestRequest {

    @Valid
    @NotNull
    @ApiModelProperty(required = true, position = 2)
    private PerData perData;

}
