import java.awt.*;
import java.util.ArrayList;

public class KinematicsUI { //consider to turn this class into an object?
	//possible fields needed for this UI
	private Frame myFrame = new Frame("2D Kinematics Animation UI"); //basic frame
	private Button getInfoButton = new Button("Get Required Information");
	
	private TextField accelLabel = new TextField("Acceleration: "); //read only acceleration
	private TextField enterAccel = new TextField(); //enter acceleration *
	private TextField accelAngleLabel = new TextField("Accelration's Angle (0 - 360): "); //read only label
	private TextField enterAccelAngle = new TextField(); //enter angle *
	
	private TextField veloLable = new TextField("Velocity: "); //read only velocity
	private TextField enterVelo = new TextField(); //enter velocity *
	private TextField veloAngleLabel = new TextField("Velocity's Angle (0 - 360): "); //read only angle
	private TextField enterVeloAngle = new TextField(); //ener angle *
	
	private TextField xPosLabel = new TextField("X Position (0 - 320): "); //read only xPos label
	private TextField enterxPos = new TextField(); //enter xPos *
	private TextField yPosLabel = new TextField("Y Position (0 - 180): "); //read only yPos label
	private TextField enteryPos= new TextField(); //enter yPos *
	
	//Action listener, and required values
	private TextField[] inputs = {enterAccel, enterAccelAngle, enterVelo, enterVeloAngle, enterxPos, enteryPos};
	private Listener listener = new Listener(inputs);
	
	//some layout constants
	private final int BOUND = 30;
	private final int DISTANCE = 15;
	
	//methods in this class
	/**
	 * To build the frame up, with these components above inside
	 */
	public void buildUI() {
		//set frame
		myFrame.setSize(400, 500); //width 400, height 900
		myFrame.setVisible(true); //show it
		myFrame.addWindowListener(listener);
		myFrame.setLayout(null);
		
		//Dimension and inset (used for project dimension control
		Dimension d = myFrame.getSize();
		Insets i = myFrame.getInsets();
		
		
		//build textfields for acceleration
		accelLabel.setBounds(i.left + 4 * BOUND + 20, i.top + BOUND, 100, 40);
		myFrame.add(accelLabel);
		accelLabel.setEditable(false); //this is read only
		enterAccel.setBounds(accelLabel.getX() + accelLabel.getWidth() + DISTANCE, accelLabel.getY(), 100, 40);
		myFrame.add(enterAccel);
		
		accelAngleLabel.setBounds(i.left + BOUND, accelLabel.getY() + accelLabel.getHeight() + DISTANCE, 210, 40);
		myFrame.add(accelAngleLabel);
		accelAngleLabel.setEditable(false); //also read only
		enterAccelAngle.setBounds(accelAngleLabel.getX() + accelAngleLabel.getWidth() + DISTANCE, accelAngleLabel.getY(), 100, 40);
		myFrame.add(enterAccelAngle);
		
		
		//build textfields for velocity
		veloLable.setBounds(i.left + 5 * BOUND + 20, accelAngleLabel.getY() + accelAngleLabel.getHeight() + DISTANCE, 70, 40);
		myFrame.add(veloLable);
		veloLable.setEditable(false); //another read only
		enterVelo.setBounds(veloLable.getX() + veloLable.getWidth() + DISTANCE, veloLable.getY(), 100, 40);
		myFrame.add(enterVelo);
		
		veloAngleLabel.setBounds(i.left + 2 * BOUND, veloLable.getY() + veloLable.getHeight() + DISTANCE, 180, 40);
		myFrame.add(veloAngleLabel);
		veloAngleLabel.setEditable(false); //read only
		enterVeloAngle.setBounds(veloAngleLabel.getX() + veloAngleLabel.getWidth() + DISTANCE, veloAngleLabel.getY(), 100, 40);
		myFrame.add(enterVeloAngle);
		
		
		//the get position labels
		xPosLabel.setBounds(i.left + 3 * BOUND, veloAngleLabel.getY() + veloAngleLabel.getHeight() + DISTANCE, 150, 40);
		myFrame.add(xPosLabel);
		xPosLabel.setEditable(false);
		enterxPos.setBounds(xPosLabel.getX() + xPosLabel.getWidth() + DISTANCE, xPosLabel.getY(), 100, 40);
		myFrame.add(enterxPos);
		
		yPosLabel.setBounds(i.left + 3 * BOUND, xPosLabel.getY() + xPosLabel.getHeight() + DISTANCE, 150, 40);
		myFrame.add(yPosLabel);
		yPosLabel.setEditable(false);
		enteryPos.setBounds(yPosLabel.getX() + yPosLabel.getWidth() + DISTANCE, yPosLabel.getY(), 100, 40);
		myFrame.add(enteryPos);
		
		
		//button
		getInfoButton.setBounds(200 - 90, yPosLabel.getY() + yPosLabel.getHeight() + DISTANCE, 180, 40);
		myFrame.add(getInfoButton);
		getInfoButton.addActionListener(listener); //add action listener, so when pressing button, it'll get info from textfields
	}
	
	/**
	 * @return -> get the user input (from listener)
	 * 0 -> acceleration 
	 * 1 -> acceleration's enter angle
	 * 2 -> velocity
	 * 3 -> velocity's enter angle
	 * 4 -> x position in simulation
	 * 5 -> y position in simulation
	 */
	public ArrayList<Double> getInputs() {
		return listener.getInputs();
	}
	
	/**
	 * @return -> get the data state (also from listener)
	 */
	public boolean getDataState() {
		return listener.getDataState();
	}
}
