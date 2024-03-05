package com.study.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		System.out.println("기상");
		System.out.println("씻기");
		System.out.println("밥먹기");
		System.out.println("운동하기");
		System.out.println("공부하기");

		SpringApplication.run(MvcApplication.class, args);
	}

}
