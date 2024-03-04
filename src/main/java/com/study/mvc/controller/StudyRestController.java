package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController // 모든 요청에 Responsebody가 붙음
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) { // 형변환 까지 자동으로 해줌
        System.out.println(helloDto);

        return "Hello";
    }
}
