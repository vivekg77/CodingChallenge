package com.coding.challenge.martianrobots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionExecutionTest {

  @Test
  @DisplayName(
      "Test if the initiate instruction Execution does return the final robot position and orientation as the expected output ")
  public void testInitiateExecutionr() {
    // Given
    RobotStatus robotStatus = new RobotStatus(Orientation.E, new Point(1, 1));
    Queue<RobotInstruction> instructionQueue = new LinkedList<>();
    instructionQueue.add(RobotInstruction.R);
    instructionQueue.add(RobotInstruction.F);
    instructionQueue.add(RobotInstruction.L);
    robotStatus.addInstructions(instructionQueue);

    RobotStatus robotStatus1 = new RobotStatus(Orientation.N, new Point(3, 2));
    Queue<RobotInstruction> instructionQueue2 = new LinkedList<>();
    instructionQueue2.add(RobotInstruction.F);
    instructionQueue2.add(RobotInstruction.R);
    robotStatus1.addInstructions(instructionQueue2);

    Queue<RobotStatus> robotStatuses = new LinkedList<>();
    robotStatuses.add(robotStatus);
    robotStatuses.add(robotStatus1);

    InstructionExecution instructionExecution =
        new InstructionExecution(robotStatuses, new Point(5, 3));

    String expectedOutput = "1 0 E\n3 3 E\n";

    // Act
    String output = instructionExecution.initiateExecution();

    // Assert
    assertEquals(expectedOutput, output);
  }
}
