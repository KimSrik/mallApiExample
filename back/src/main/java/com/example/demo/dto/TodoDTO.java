package com.example.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
	
	private Long tno;
	
	private String title;
	
	private String writer;
	
	private boolean complete;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dueDate;
	// front와 통신을 하면 front에 맞는 형식으로 바꿔주기 위해 JsonFormat 어노테이션을 써서 변환
	
}
