package com.example.ClinicalCenter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class ClinicalCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalCenterApplication.class, String.valueOf(args));
	}

}
