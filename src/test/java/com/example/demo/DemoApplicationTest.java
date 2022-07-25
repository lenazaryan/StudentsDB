package com.example.demo;

import com.example.demo.student.StudentController;
import com.example.demo.student.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTest {

	@Autowired
	private StudentController studentController;
	@Autowired
	private StudentService studentService;

	@Test
	public void contextLoads() throws Exception {
		assertThat(studentController).isNotNull();
		assertThat(studentService).isNotNull();
	}
}
