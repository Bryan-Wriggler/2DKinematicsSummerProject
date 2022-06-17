import java.util.Timer;
import java.util.TimerTask;

import junit.framework.Test;

public class ClientProgram {
	
	public static void main(String[] args) throws InterruptedException {
		KinematicsUI uI = new KinematicsUI();
		uI.buildUI();
		
		//control the time (let the get data delay until it finally has data
		ClientProgram test = new ClientProgram(); //the object that need to test (from internet)
		
		Timer timer = new Timer();
		boolean hasData = false;
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay task");
				
				if (uI.getDataState()) {
					
					synchronized(test) { //IDK, but try it
						test.notify();
					}
				}
			}
			
		};
		
		//schedule the task, and wait till ui has true data
		timer.schedule(task, 3000, 3000);
		
		synchronized(test) {
			test.wait();
		}
		//re
		
		System.out.println(uI.getInputs());
		System.out.println(task.cancel()); //sea if the task will cancel after it
		
		timer.cancel(); //cancel the timer
	}
}
