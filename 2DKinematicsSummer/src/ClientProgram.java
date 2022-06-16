import java.util.Timer;
import java.util.TimerTask;

public class ClientProgram {
	
	public static void main(String[] args) {
		KinematicsUI uI = new KinematicsUI();
		uI.buildUI();
		
		//control the time (let the get data delay until it finally has data
		Timer timer = new Timer();
		boolean hasData = false;
		
		/*//fail
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay task");
			}
			
		};
		
		while (!hasData) { //before it has data, it'll keep doing the task
			timer.schedule(task, 1000); //delay 1000 ms
			hasData = uI.getDataState(); //update it
			
			//try to cancel the scheduled task?
			timer.cancel();
		}
		*/
		//re
		
		System.out.println(uI.getInputs());
	}
}
