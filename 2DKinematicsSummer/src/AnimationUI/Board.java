package AnimationUI;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	//constants
	private static final int actualHeight = 1820;
	private static final int actualWidth = 3220;
	private static final int ballRadius = 10; //this is also the part that'll add onto the initial position of ball
	private static final int meterToPixel = 10; //the ratio between actual meter and pixel in this project
	
	//limits
	private static final int limitL = 0 + ballRadius, limitR = actualWidth - ballRadius; //left and right limit
	private static final int limitU = 0 + ballRadius, limitB = actualHeight - ballRadius; //up and bottom limit (up starts from 0)
	
	//fields
	private int x, y;
	
	//for calculating the velocity and position (calculated through trig)
	private double velocityX, velocityY;
	private final double accelX, accelY; //this will stay as a constant (but different based on inputs)
	
	/**
	 * @param xPos -> the x position (input by user)
	 * @param yPos -> the y position (input by user)
	 * @param velocity -> initial velocity
	 * @param velocityAngle -> velocity's angle (from 0 to 360)
	 * @param accel -> acceleration (as constant)
	 * @param accelAngle -> acceleration's angle
	 */
	public Board(double xPos, double yPos, double velocity, double velocityAngle, double accel, double accelAngle) {
		//update velocity and acceleration
		accelX = xCalculate(accel, accelAngle);
		accelY = yCalculate(accel, accelAngle);
		
		velocityX = xCalculate(velocity, velocityAngle);
		velocityY = - yCalculate(velocity, velocityAngle); //cause computer use opposite coordinate, soe set as negative
		
		//set x and y
		x = (int) xPos + ballRadius;
		y = (int) yPos + ballRadius;
		
	}
	
	/**
	 * This method will create the designed UI (need to be called after all the values were already initialized
	 */
	private void initUI() {
		
	}
	
	
	//helper methods
	/**
	 * @param value -> input value
	 * @param angle -> the angle (direction, in degree)
	 * @return -> return the x direction's value (cos function)
	 */
	private double xCalculate(double value, double angle) {
		angle = Math.toRadians(angle); //turn to radians
		
		return Math.cos(angle) * value;
	}
	
	/**
	 * @param value -> input value
	 * @param angle -> angle of input value (in degree)
	 * @return -> the y direction's value (sin function)
	 */
	private double yCalculate(double value, double angle) {
		angle = Math.toRadians(angle);
		
		return Math.sin(angle) * value;
	}
}
