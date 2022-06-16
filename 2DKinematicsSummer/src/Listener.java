import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Listener implements WindowListener, ActionListener {
	
	//fields
	private TextField[] listInput; //store the textfields that will get user input
	private ArrayList<Double> inputs; //get the text after the button was pressed
	private boolean hasData; //this will only turn true when there is data (button pressed)
	
	
	//constructor
	public Listener(TextField[] dataList) {
		listInput = dataList;
		inputs = new ArrayList<Double>();
		hasData = false;
	}
	
	//Window Listener
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Activated");
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Closed");
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Closing");
		((Frame) arg0.getSource()).dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Deactivated");
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Deiconified");
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Iconified");
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Opened");
		
	}

	
	//Action Listener
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Button button = (Button) arg0.getSource();
		
		//if there is one that's not boolean, then reset everything
		boolean allDouble = true;
		
		for (int i=0; i<listInput.length; i++) { //get text from textfields, and plug into the inputs list
			double get = Double.parseDouble(listInput[i].getText()); //this is assuming all inputs are just values
			inputs.add(get);
		}
		
		//here we got the data, turn it to true
		hasData = true;
	}
	
	//other methods
	/**
	 * @return -> get all the needed inputs from user (after clicking the button)
	 */
	public ArrayList<Double> getInputs() {
		return inputs;
	}
	
	/**
	 * @return -> get if there is data
	 */
	public boolean getDataState() {
		return hasData;
	}
}
