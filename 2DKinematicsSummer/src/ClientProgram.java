import java.util.Timer;
import java.util.TimerTask;

import junit.framework.Test;

public class ClientProgram {
	
	public static void main(String[] args) throws InterruptedException {
		KinematicsUI uI = new KinematicsUI();
		uI.buildUI();
		
		//control the time (let the get data delay until it finally has data
		ClientProgram test = new ClientProgram(); //the object that need to test (synchronize)
		
		Timer timer = new Timer(); //timer
		
		TimerTask task = new TimerTask() { //anonymous class of TimerTask
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay task");
				
				if (uI.getDataState()) { //the condition to let it stop
					
					synchronized(test) { //IDK, but try it  (maybe it'll send a signal to clientprogram,  and tell it that it's able to end
						test.notify();
					}
				}
			}
			
		};
		
		//schedule the task, and wait till ui has true data
		timer.schedule(task, 3000, 3000);
		
		synchronized(test) { //wait until the result was fulfilled (the condition is true)
			test.wait();
		}
		//re
		
		System.out.println(uI.getInputs());
		System.out.println(task.cancel()); //sea if the task will cancel after it
		
		timer.cancel(); //cancel the timer
	}
}
