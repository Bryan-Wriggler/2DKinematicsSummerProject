import java.awt.*;

public class KinematicsUI {
	//possible fields needed for this UI
	public static Frame myFrame = new Frame("2D Kinematics Animation UI"); //basic frame
	public static Button getInfoButton = new Button("Get Required Information");
	
	public static TextField accelLabel = new TextField("Acceleration: "); //read only acceleration
	public static TextField enterAccel = new TextField(); //enter acceleration
	public static TextField accelAngleLabel = new TextField("Accelration's Angle (0 - 360): "); //read only label
	public static TextField enterAccelAngle = new TextField(); //enter angle
	
	public static TextField veloLable = new TextField("Velocity: "); //read only velocity
	public static TextField enterVelo = new TextField(); //enter velocity
	public static TextField veloAngleLabel = new TextField("Velocity's Angle (0 - 360): "); //read only angle
	public static TextField enterVeloAngle = new TextField(); //ener angle
	
	public static TextField xPosLabel = new TextField("X Position: "); //read only xPos label
	public static TextField enterxPos = new TextField(); //enter xPos
	public static TextField yPosLabel = new TextField("Y Position: "); //read only yPos label
	public static TextField enteryPose= new TextField(); //enter yPose
	
	//Action listener
	public static Listener listener = new Listener();
	
	//some layout constants
	public static final int BOUND = 30;
	public static final int DISTANCE = 15;
	
	
	/**
	 * To build the frame up, with these components above inside
	 */
	public static void buildUI() {
		//set frame
		myFrame.setSize(500, 700); //width 400, height 900
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
		
	}
	
	public static void main(String[] args) {
		buildUI();
	}
}
