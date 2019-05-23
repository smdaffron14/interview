package com.deloitte.interview.solution.advanced;

/**
 * Simple driver code that instantiates and runs the {@link ElevatorSystem}
 * 
 * @author MD
 */
public class App {
	public static void main(String[] args) {

		int d = Double.valueOf(8.25 / 2).intValue();
		System.out.println(d);
		//		App app = new App();
//		app.runElevators();
	}

	private void runElevators() {
		ElevatorSystem system = new ElevatorSystem(18);
		system.start();
		
		// Rider 1
		system.call(1, 5);
		
		// Rider 2
		system.call(3, 5);
		
		// Rider 3
		system.call(7, 10);
		
		// Rider 4
		system.call(2, 3);
		
		// Rider 5
		system.call(7, 12);
		
		// Rider 6
		system.call(8, 10);
		
		// Rider 7
		system.call(9, 15);
		
		// Rider 8
		system.call(16, 18);
		
		// Rider 8
		system.call(9, 13);
		
		// Rider 9 (should be rejected if all previous riders are on same elevator)
		system.call(9, 10);
	}
}
