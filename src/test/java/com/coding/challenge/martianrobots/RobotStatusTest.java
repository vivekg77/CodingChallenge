package com.coding.challenge.martianrobots;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RobotStatusTest {

  @Test
  @DisplayName(
      "Test getOrientation () method of RobotStatus class if it returns the correct orientation of that Robot")
  public void testGetOrientation(){
    // Given
    RobotStatus robotStatus = new RobotStatus(Orientation.E, null);

    // When
    Orientation o = robotStatus.getOrientation();

    // Then
    assertEquals(Orientation.E, o);
  }

  @Test
  @DisplayName(
      "Test getCurrentPOsition() method of RobotStatus class if it returns the correct x, y coordinates  of that Robot")
  public void testGetCurrentPosition(){

    // Given
    RobotStatus robotStatus = new RobotStatus(Orientation.E, new Point(1, 3));

    // When
    Point p = robotStatus.getCurrentPosition();

    // Then
    assertEquals(new Point(1, 3), p);
  }

  @Test
  @DisplayName("Test the addInstruction and remove instruction from queue methods")
  public void testAddInstructionsAndRemoveFromQueue() {
    // Given
    RobotStatus robotStatus = new RobotStatus(Orientation.E, new Point(1, 2));
    Queue<RobotInstruction> queue = new LinkedList<>();
    queue.add(RobotInstruction.R);
    queue.add(RobotInstruction.L);
    robotStatus.addInstructions(queue);

    // When
    RobotInstruction x = robotStatus.dequeueNextInstruction();
    RobotInstruction y = robotStatus.dequeueNextInstruction();

    // Then
    assertEquals(RobotInstruction.R, x);
    assertEquals(RobotInstruction.L, y);
  }

  @Test
  @DisplayName("Test the execute Next Instruction method ")
  public void testExecuteNextInstruction() {
    // Given
    RobotStatus robotStatus = new RobotStatus(Orientation.E, new Point(1, 2));
    Queue<RobotInstruction> queue = new LinkedList<>();
    queue.add(RobotInstruction.F);
    queue.add(RobotInstruction.L);
    queue.add(RobotInstruction.F);
    robotStatus.addInstructions(queue);

    // When
    robotStatus.executeNextInstruction();
    // Then
    assertEquals(new Point(2, 2), robotStatus.getCurrentPosition());
    assertEquals(Orientation.E, robotStatus.getOrientation());
    assertTrue(robotStatus.canExecuteNextInstruction());

    // When
    robotStatus.executeNextInstruction();
    // Then
    assertEquals(new Point(2, 2), robotStatus.getCurrentPosition());
    assertEquals(Orientation.N, robotStatus.getOrientation());
    assertTrue(robotStatus.canExecuteNextInstruction());

    // When
    robotStatus.executeNextInstruction();
    // Then
    assertEquals(new Point(2, 3), robotStatus.getCurrentPosition());
    assertEquals(Orientation.N, robotStatus.getOrientation());
    assertFalse(robotStatus.canExecuteNextInstruction());
  }
}
