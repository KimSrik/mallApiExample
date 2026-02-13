package com.example.demo.Service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServicesTests {
	
	@Autowired
	private TodoService todoService;
	
	@Test
	public void testRegister() {
		TodoDTO todoDTO = TodoDTO.builder()
				.title("서비스 테스트")
				.writer("테스터")
				.dueDate(LocalDate.of(2026, 04, 20))
				.build();
		
		Long tno = todoService.register(todoDTO);
		
		log.info("tno : " + tno);
	}
}
