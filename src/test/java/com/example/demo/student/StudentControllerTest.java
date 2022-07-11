package com.example.demo.student;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.testng.Assert;
import org.assertj.core.api.AssertionsForClassTypes;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.and;

class StudentControllerTest {

    final String BASE_URL = "http://localhost:8080/api";
    StudentController studentController;

    @Test
    void getAllStudents(String url) throws IllegalArgumentException {
        //given
        String path = "/students";
        url = BASE_URL + path;

        //when

        //then
//        List<Student> expectedResult = ;
//        assertThat(actualResult, HttpStatus.OK(200), expectedResult);
    }

    @Test
    void getStudentByID() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }
}