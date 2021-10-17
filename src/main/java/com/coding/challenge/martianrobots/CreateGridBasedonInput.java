package com.coding.challenge.martianrobots;

import lombok.extern.log4j.Log4j2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@Log4j2
public class CreateGridBasedonInput {

  private final String fileDir;
  private Point gridBounds;


  public CreateGridBasedonInput(String fileDir) {
    this.fileDir = fileDir;
    this.gridBounds = null;

  }

  public Point generateInitialSetUp() throws IOException {

    BufferedReader bufferedReader = null;
    FileReader fileReader = null;

    fileReader = new FileReader(fileDir);
    bufferedReader = new BufferedReader(fileReader);

    String gridBoundsString;

    if ((gridBoundsString = bufferedReader.readLine()) != null) {
      System.out.println("grid Bounds are ::: " + gridBoundsString);
      gridBounds = generateGrid(gridBoundsString);
    }

    String currentLine;


    while ((currentLine = bufferedReader.readLine()) != null) {
      if (!currentLine.isEmpty()) {
        String initialRobotStatus = currentLine;
        System.out.println("initialRobotStatus ::: " + initialRobotStatus);
        String instructions = bufferedReader.readLine();
        System.out.println("instructions ::: " + instructions);

      }
    }

    return gridBounds;
  }

  // This method generates the grid for robots to move on based on the input file
  public Point generateGrid(String gridString) {
    String delimiters = " ";
    StringTokenizer tokenizer = new StringTokenizer(gridString, delimiters);

    int xBounds = Integer.parseInt(tokenizer.nextToken());
    int yBounds = Integer.parseInt(tokenizer.nextToken());

    return new Point(xBounds, yBounds);
  }


}
