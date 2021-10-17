package com.coding.challenge.martianrobots;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReadFileTest {

    @Test
    public void readFile() throws IOException {

        String fileDir = "src/test/resources/sampleInput.txt";

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        fileReader = new FileReader(fileDir);
        bufferedReader = new BufferedReader(fileReader);

        String gridBoundsString;

        gridBoundsString = bufferedReader.readLine();

        String currentLine = bufferedReader.readLine();

        System.out.println("robot initial state is ::: " + currentLine);
        assertNotNull(currentLine);
        assertEquals("1 1 E", currentLine);
        assertEquals("5 3", gridBoundsString);
    }


}
