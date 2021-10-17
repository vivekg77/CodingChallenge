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
  private Queue<RobotStatus> robotStatuses;


  public CreateGridBasedonInput(String fileDir) {
    this.fileDir = fileDir;
    this.gridBounds = null;
    this.robotStatuses = new LinkedList<>();
  }

  public InstructionExecution generateInitialSetUp() throws IOException {

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
        RobotStatus rs = setRobotInitialPosition(initialRobotStatus);
        rs.addInstructions(generateInstructionQueue(instructions));
        robotStatuses.add(rs);

      }
    }

    return new InstructionExecution(robotStatuses, gridBounds);
  }

  // This method takes the instruction String from the input file and put all the instructions into
  // a Linked List
  private Queue<RobotInstruction> generateInstructionQueue(String instructions) {

    System.out.println("instructions are ::: " + instructions);
    Queue<RobotInstruction> instructionQueue = new LinkedList<>();

    for (char c : instructions.toCharArray()) {
      RobotInstruction i = RobotInstruction.valueOf(Character.toString(c));

      instructionQueue.add(i);
    }

    return instructionQueue;
  }

  private RobotStatus setRobotInitialPosition(String initialState) {
    String delimiters = " ";
    StringTokenizer tokenizer = new StringTokenizer(initialState, delimiters);

    int xCoordinate = Integer.parseInt(tokenizer.nextToken());
    int yCoordinate = Integer.parseInt(tokenizer.nextToken());
    Point startCoordinates = new Point(xCoordinate, yCoordinate);

    Orientation orientation = Orientation.valueOf(tokenizer.nextToken());

    return new RobotStatus(orientation, startCoordinates);
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
