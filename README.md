# martian-robots
Martian Robots Coding Challenge

This project generates a grid on the Martian surface for the robots to move.
It takes the input from a file and creates the following:
a) grid outer limits
b) robots' initial position (x and y coordinates) and orientation
c) and the string containing the instructions to move the robot on the grid

1. CreateGridBasedonInput class
   Reads the input file and exrracts the grid limit, robot posistion and instructions

2. RobotStatus
   Is Associated with the the status of each robot at each stage and this object contains various methods to
   move , rotate and set the exception flag when the robot goes out of limit.

3. InstructionExecution class
   This is the main execution class which initiates the execution of instructions for each robot to move on the grid.

4. Orientation and RobotInstruction class
   These are enums specifying the allowed values for orientation and instructions

The testGridSetup method in ReadFileTest class is created to test the whole set of clasees.
It takes the input file and generates the desired output.

1 1 E <br>
3 3 N LOST<br>
2 3 S

Clone the following repository:




# Build and Test
mvn clean install