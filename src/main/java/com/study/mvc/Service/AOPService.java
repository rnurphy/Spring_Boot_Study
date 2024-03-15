package com.study.mvc.Service;

import com.study.mvc.aop.annotation.ParamsAspect;
import org.springframework.stereotype.Service;

@Service
public class AOPService {

    @ParamsAspect
    public String test(String name, int age) {

        return "이름: " + name + ", 나이: " + age;
    }
}
