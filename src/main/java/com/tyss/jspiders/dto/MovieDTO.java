package com.tyss.jspiders.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class MovieDTO {
	private String title;
	private String industry;
	private Integer releaseyear;
	private Float imdbRating;
	private String studio;
	
	
	private List<ActorDTO> actors;
	
	
	private LanguageDTO language;
	
	private FinancialDTO financial;


}
