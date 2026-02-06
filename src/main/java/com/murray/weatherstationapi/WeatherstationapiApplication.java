package com.murray.weatherstationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class WeatherstationapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherstationapiApplication.class, args);
	}

}
