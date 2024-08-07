package com.hocelot.interview.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ScorModResponse {

	private BigDecimal prediction;

	@JsonAlias("class")
	private String clazz;

	private int code;

	private List<String> message;

}
