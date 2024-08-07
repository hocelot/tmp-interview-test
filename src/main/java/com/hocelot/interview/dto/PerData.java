package com.hocelot.interview.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Valid
@ApiModel(description = "Personal Data request")
public class PerData {

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{4}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[A-Za-z\\d]{3,8}$", message = "Format Error in documentNumber")
    @ApiModelProperty(value = "CURP/RFC (Mandatory)", required = true, example = "ABCD230131XXXXXXX", position = 5)
    private String documentNumber;

    @ApiModelProperty(hidden = true)
    private String identityDocument;

    @ApiModelProperty(required = true, example = "Andres Manuel Lopez Obrador", value= "Nombre Completo")
    private String fullname;

}
