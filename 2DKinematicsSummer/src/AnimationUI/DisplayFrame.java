package AnimationUI;

import java.util.ArrayList;

import javax.swing.JFrame;

public class DisplayFrame extends JFrame {

	public DisplayFrame(ArrayList<Double> inputs) {
		initUI(inputs);
	}
	
	public void initUI(ArrayList<Double> inputs) {
		//4: xPos, 5: yPos, 2: velo, 3: veloAngle, 0: accel, 1: accelAngle
		add(new Board(inputs.get(4), inputs.get(5), inputs.get(2), inputs.get(3), inputs.get(0), inputs.get(1))); //add panel to frame
		
		setResizable(false);
        pack();
        
        setTitle("Kinematics Animation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
