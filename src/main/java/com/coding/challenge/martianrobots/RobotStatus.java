package com.coding.challenge.martianrobots;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import static com.coding.challenge.martianrobots.RobotInstruction.*;


public class RobotStatus {

  private Queue<RobotInstruction> instructions;
  private Orientation orientation;
  private Point currentPosition;
  private Point previousPosition;
  private boolean isLost;

  public RobotStatus(Orientation orientation, Point position) {
    this.orientation = orientation;
    this.currentPosition = position;
    this.instructions = new LinkedList<>();
    this.isLost = false;
    this.previousPosition = null;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public Point getCurrentPosition() {
    return currentPosition;
  }

  public Point getPreviousPosition() {
    return previousPosition;
  }

  public void setLostState(boolean isLost) {
    this.isLost = isLost;
  }

  public Queue<RobotInstruction> getInstructions() {
    return instructions;
  }

  public void addInstructions(Queue<RobotInstruction> instructions) {
    this.instructions.addAll(instructions);
  }

  public RobotInstruction dequeueNextInstruction() {
    assert (!instructions.isEmpty());
    return instructions.poll();
  }

  public boolean canExecuteNextInstruction() {
    return (instructions.size() > 0);
  }

  public void executeNextInstruction() {
    assert (!instructions.isEmpty());

    RobotInstruction i = dequeueNextInstruction();

    switch (i) {
      case F:
        previousPosition = currentPosition;
        currentPosition = move(i);
        break;
      default:
        orientation = rotate(i);
    }
  }

  public Point positionAfterNextInstructionExecution() {
    assert (!instructions.isEmpty());
    return move(instructions.peek());
  }

  private Orientation rotate(RobotInstruction i) {
    if (i == R) {
      return Orientation.rotatingClockwise(orientation);
    } else {
      return Orientation.rotatingAntiClockwise(orientation);
    }
  }

  private Point move(RobotInstruction i) {
    int x = currentPosition.x;
    int y = currentPosition.y;

    if (i == F) {
      switch (getOrientation()) {
        case N:
          return new Point(x, y + 1);
        case S:
          return new Point(x, y - 1);
        case E:
          return new Point(x + 1, y);
        case W:
          return new Point(x - 1, y);
      }
    }
    return currentPosition;
  }

  @Override
  public String toString() {
    if (isLost) {
      return String.format(
          "%d %d %s LOST", previousPosition.x, previousPosition.y, orientation.toString());
    } else {
      return String.format(
          "%d %d %s", currentPosition.x, currentPosition.y, orientation.toString());
    }
  }
}
