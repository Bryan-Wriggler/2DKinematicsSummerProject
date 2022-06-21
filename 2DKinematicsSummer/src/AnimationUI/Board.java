package AnimationUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {
	
	//constants
	private static final int actualHeight = 930;
	private static final int actualWidth = 1630;
	private static final int ballRadius = 15; //this is also the part that'll add onto the initial position of ball
	private static final int meterToPixel = 20; //the ratio between actual meter and pixel in this project
	
	private static final double updateTime = 0.02; //10 ms
	
	//limits
	private static final int limitL = 0, limitR = actualWidth - 2 * ballRadius; //left and right limit
	private static final int limitU = 0, limitB = actualHeight - 2 * ballRadius; //up and bottom limit (up starts from 0)
	
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
		//update velocity and acceleration (change meters to pixels)
		accelX = xCalculate(accel, accelAngle) * meterToPixel;
		accelY = yCalculate(accel, accelAngle) * meterToPixel;
		
		velocityX = xCalculate(velocity, velocityAngle) * meterToPixel;
		velocityY = - yCalculate(velocity, velocityAngle) * meterToPixel; //cause computer use opposite coordinate, soe set as negative
		
		//set x and y
		x = (int) xPos * meterToPixel + ballRadius;
		y = (int) yPos * meterToPixel + ballRadius;
		
		//initialize the board
		initUI();
	}
	
	/**
	 * This method will create the designed UI (need to be called after all the values were already initialized
	 */
	private void initUI() {
		setPreferredSize(new Dimension(actualWidth, actualHeight));
		
		//create timer
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 20); //display after first second, and update every 10 ms
		
		System.out.println(velocityX + ", " + velocityY + ", " + accelX + ", " + accelY + ", " + x + ", " + y);
	}
	
	/**
	 * This method will paint the circle at a better position
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //called it in super
		setForeground(Color.red);
		g.fillOval(x, y, 2 * ballRadius, 2 * ballRadius);
	}
	
	/**
	 * the anonymous class that'll keep running the task of repaint
	 */
	private class ScheduleTask extends TimerTask {

		@Override
		public void run() {
			if (x <= limitL || x >= limitR) { //it is currently out of x pos, reverse the x velocity
				velocityX *= -1;
			}
			if (y <= limitU || y >= limitB) { //it is currently out of y pos, reverse the y velocity
				velocityY *= -1;
			}
			
			//update x and y
			x = (int) (x + velocityX * updateTime);
			y = (int) (y + velocityY * updateTime);
			
			repaint();
		}
		
	};
	
	
	
	
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
