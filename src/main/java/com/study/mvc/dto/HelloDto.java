package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor  // @AllArgsConstructor를 쓰게되면 무조건 모든 값을 넣어야되어버림
@Data
public class HelloDto {
    private String name;
    private int age;
}
