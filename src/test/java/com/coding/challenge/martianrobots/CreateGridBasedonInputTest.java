package com.coding.challenge.martianrobots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateGridBasedonInputTest {

  @Test
  @DisplayName("Test if the Upper Right Corner of the Grid is parsed properly from the Input")
  public void testUpperRightCornerOfTheGrid() throws IOException {
    // Given
    CreateGridBasedonInput createGridBasedonInput =
            new CreateGridBasedonInput("src/test/resources/sampleInput.txt");
    Point expectedUpperRightBoundary = new Point(5, 3);
    // When
    InstructionExecution instructionExecution = createGridBasedonInput.generateInitialSetUp();

    // Then
    assertEquals(expectedUpperRightBoundary, instructionExecution.getGridBounds());
  }

  @Test
  @DisplayName("Test if the Posistion of all robots are parsed properly from the Input")
  public void testRobotPositions() throws IOException {
    //Given
    CreateGridBasedonInput createGridBasedonInput = new CreateGridBasedonInput("src/test/resources/sampleInput.txt");

    //When
    InstructionExecution instructionExecution = createGridBasedonInput.generateInitialSetUp();

    //Then
    assertEquals(instructionExecution.getRobotStatuses().size(), 3);

    RobotStatus r1 = instructionExecution.getRobotStatuses().poll();
    RobotStatus r2 = instructionExecution.getRobotStatuses().poll();
    RobotStatus r3 = instructionExecution.getRobotStatuses().poll();

    assertEquals(new Point(1, 1), r1.getCurrentPosition());
    assertEquals(Orientation.E, r1.getOrientation());

    assertEquals(new Point(3, 2), r2.getCurrentPosition());
    assertEquals(Orientation.N, r2.getOrientation());

    assertEquals(new Point(0, 3), r3.getCurrentPosition());
    assertEquals(Orientation.W, r3.getOrientation());
  }

  @Test
  @DisplayName("Test if the Instructions to move robots are parsed properly from the Input")
  public void testRobotInstructions() throws IOException {
    // Given
    CreateGridBasedonInput createGridBasedonInput =
            new CreateGridBasedonInput("src/test/resources/sampleInput.txt");

    // When
    InstructionExecution instructionExecution = createGridBasedonInput.generateInitialSetUp();

    //Then
    Queue<RobotInstruction> queue = instructionExecution.getRobotStatuses().poll().getInstructions();
    assertEquals(RobotInstruction.R, queue.poll());
    assertEquals(RobotInstruction.F, queue.poll());

  }






}
