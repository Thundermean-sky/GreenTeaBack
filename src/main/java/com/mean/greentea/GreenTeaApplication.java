package com.mean.greentea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mean.greentea.dao")
public class GreenTeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenTeaApplication.class, args);
	}

}
