package com.study.mvc.controller;
/*
* GET 요청
* 메소드명 getStudentInfo()
* URL - /student
* Params: name, age, phone, address
* 응답 - JSON(name, age, phone, address)
* */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.Entity.Student;
import com.study.mvc.dto.StudentReqDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException {
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;
        if(students != null) {
            if(!students.isBlank()) {
                ObjectMapper studentCookie = new ObjectMapper();
                studentList = studentCookie.readValue(students, List.class);
                lastId = studentList.get(studentList.size() - 1).getStudentId();
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String newStudents = newStudentList.writeValueAsString(studentList);
        ResponseCookie responseCookie = ResponseCookie
                .from("test", "test_data")
                .httpOnly(true).secure(true).path("/").maxAge(60).build();

        return ResponseEntity.created(null).header(HttpHeaders.SET_COOKIE, responseCookie.toString()).body(student);
    }

    @GetMapping("/student")
    // body로 어떤 데이터를 응답할지 모르기때문에 <?>
    public ResponseEntity<?> getStudentInfo(StudentReqDto studentReqDto) {

        return ResponseEntity.ok().header("test", "header_test").body(studentReqDto.toRespDto());
//        return ResponseEntity.badRequest().header("test", "header_test").body(studentReqDto.toRespDto());
//        헤더는 있어도 그만 없어도 그만
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
        List<Student> studentList = List.of(
                new Student(1, "김준일"),
                new Student(2, "김준이"),
                new Student(3, "김준삼"),
                new Student(4, "김준사")
        );

        Student findStudent = null;

        for(Student student : studentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
        }

//        또 다른 방법
//        Optional<Student> optionalStudent = studentList.stream().filter(student -> student.getStudentId() == studentId).findFirst();
//
//        if(optionalStudent.isEmpty())
//            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 학생입니다."));
//
//        findStudent = optionalStudent.get();

        if(findStudent == null) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 학생입니다."));
        }

        return ResponseEntity.ok().body(findStudent);
    }
}
