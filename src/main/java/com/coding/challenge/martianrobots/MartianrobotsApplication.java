package com.coding.challenge.martianrobots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MartianrobotsApplication {

	public static void main(String[] args) throws IOException {


		String inputFile = "src/main/resources/sampleInput.txt";


		CreateGridBasedonInput createGridBasedonInput = new CreateGridBasedonInput(inputFile);

		InstructionExecution instructionExecution = createGridBasedonInput.generateInitialSetUp();

		String strOutput = instructionExecution.initiateExecution();

		System.out.println(strOutput);


		//SpringApplication.run(MartianrobotsApplication.class, args);
	}

}
