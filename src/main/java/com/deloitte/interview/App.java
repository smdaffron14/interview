package com.deloitte.interview;

/**
 * Simple driver code that instantiates and runs the {@link ElevatorSystem}
 * 
 * @author MD
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		app.runElevators();
	}

	private void runElevators() {
		ElevatorSystem system = new ElevatorSystem(20);
		system.call(5);
		system.call(7);
		system.call(2);
		system.call(18);
	}
}
