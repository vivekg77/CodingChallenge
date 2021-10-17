package com.coding.challenge.martianrobots;

import java.awt.*;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class InstructionExecution {

    private final Queue<RobotStatus> robotStatuses;
    private final Point gridBounds;
    private Set<Point> robotScents;

    public InstructionExecution(Queue<RobotStatus> robotStatuses, Point gridBounds) {
        this.robotStatuses = robotStatuses;
        this.gridBounds = gridBounds;
        this.robotScents = new HashSet<>();
    }

    public Point getGridBounds() {
        return gridBounds;
    }

    public Set<Point> getRobotScents() {
        return robotScents;
    }

    public Queue<RobotStatus> getRobotStatuses() {
        return robotStatuses;
    }

    public String initiateExecution() {
        StringBuilder sb = new StringBuilder();
        for (RobotStatus status : robotStatuses) {
            executeRobotInstructions(status);

            sb.append(status.toString() + '\n');
        }
        return sb.toString();
    }

    private void executeRobotInstructions(RobotStatus status) {

        while(status.canExecuteNextInstruction()) {
            if(isOnScentedPosition(status.getCurrentPosition())
                    && isOffGridPosition(status.positionAfterNextInstructionExecution())) {
                status.dequeueNextInstruction();
            } else {
                status.executeNextInstruction();
                if(isOffGridPosition(status.getCurrentPosition())) {
                    status.setLostState(true);
                    //Add last valid grid position to robotScent set
                    addRobotScent(status.getPreviousPosition());
                    break;
                }
            }
        }
    }

    private boolean isOnScentedPosition(Point p) {
        return getRobotScents().contains(p);
    }

    private boolean isOffGridPosition(Point p) {
        return (p.x > gridBounds.x
                || p.y > gridBounds.y
                || p.x < 0
                || p.y < 0);
    }

    private void addRobotScent(Point p) {
        robotScents.add(p);
    }
}
