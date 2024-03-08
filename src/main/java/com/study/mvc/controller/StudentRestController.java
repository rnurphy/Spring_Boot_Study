package com.study.mvc.controller;

import com.study.mvc.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentRestController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/ex/students")
    public ResponseEntity<?> students() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/ex/student/{index}")
    public ResponseEntity<?> students(@PathVariable int index) {
        return ResponseEntity.ok(studentService.getStudent(index));
    }
}
