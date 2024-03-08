package com.study.mvc.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
public class Study {
    private int id;
    private String name;
    private int age;
    private LocalDateTime create_date;
}
