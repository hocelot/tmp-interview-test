package com.hocelot.interview.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScorModRequest {

	@JsonProperty("Cuota mensual")
	private Double cuotaMensual;

}
