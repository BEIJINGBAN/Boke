package com.example.boke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.boke")
@SpringBootApplication
public class BokeApplication {

	public static void main(String[] args) {
 		SpringApplication.run(BokeApplication.class, args);
	}

}
