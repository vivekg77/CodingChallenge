package com.coding.challenge.martianrobots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MartianrobotsApplication {

	public static void main(String[] args) {


		String inputFile = "src/main/resources/sampleInput.txt";


		CreateGridBasedonInput createGridBasedonInput = new CreateGridBasedonInput(inputFile);




		SpringApplication.run(MartianrobotsApplication.class, args);
	}

}
