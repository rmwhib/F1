package com.example.F1.Api;

import com.example.F1.Api.RaceDetails.Race;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class F1ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(F1ApiApplication.class, args);
	}




}
