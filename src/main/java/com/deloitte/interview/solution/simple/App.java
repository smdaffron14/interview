package com.deloitte.interview.solution.simple;

/**
 * Driver code to instantiate simple solution
 * to Elevator Conundrum CDT interview problem
 * 
 * @author MD
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		Elevator elevator = new Elevator(18);
		
		// Execute the elevator on a separate thread
		// so new floor requests can be enqueued while
		// the elevator is in motion
		Runnable elevatorRunnable = new Runnable() {
			@Override
			public void run() {
				elevator.run();
			}
		};
		Thread elevatorRunThread = new Thread(elevatorRunnable);
		elevatorRunThread.start();
		
		// Add stop requests while elevator is in motion
		elevator.addFloorStop(2);
		elevator.addFloorStop(6);
		elevator.addFloorStop(1);
		elevator.addFloorStop(12);
		elevator.addFloorStop(15);
		elevator.addFloorStop(7);
		
		Thread.sleep(500);
		elevator.addFloorStop(8);
		elevator.addFloorStop(3);
		elevator.addFloorStop(16);
	}
}
