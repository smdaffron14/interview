package com.deloitte.interview.solution.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A wrapper class that encapsulates all {@link Elevator}s in the
 * system. (Currently two for this example)
 * 
 * @author MD
 */
public class ElevatorSystem {

	private Elevator elevatorA;
	private Elevator elevatorB;
	
	ExecutorService serviceA = Executors.newSingleThreadExecutor();
	ExecutorService serviceB = Executors.newSingleThreadExecutor();

	ElevatorSystem(int numberOfFloors) {
		// Both elevators serve all floors
		elevatorA = new Elevator(numberOfFloors);
		elevatorB = new Elevator(numberOfFloors);
	}

	/**
	 * Initiates a floor request to the elevator(s) based on which one is closest
	 * to the desired floor
	 */
	public void call(int from, int to) {
		int distanceA = Math.abs(elevatorA.getCurrentFloor() - from);
		int distanceB = Math.abs(elevatorB.getCurrentFloor() - from);

		// Determine which elevator is currently closest to the 
		// requested floor
		int shortestDistance = Math.min(distanceA, distanceB);

		if (shortestDistance == distanceA) {
			// Send two floor requests, one for pickup, one for drop-off
			elevatorA.addFloorRequest(elevatorA.getFloorByNumber(from),
					new StopRequest(RequestType.ENTER));
			elevatorA.addFloorRequest(elevatorA.getFloorByNumber(to),
					new StopRequest(RequestType.EXIT));
		} else {
			// Send two floor requests, one for pickup, one for drop-off
			elevatorB.addFloorRequest(elevatorB.getFloorByNumber(from),
					new StopRequest(RequestType.ENTER));
						
			elevatorB.addFloorRequest(elevatorB.getFloorByNumber(to),
					new StopRequest(RequestType.EXIT));
		}
	}
	
	/**
	 * Initiates a separate thread for each elevator so that they may run
	 * and process floor requests in parallel
	 */
	public void start() {
		
		Runnable elevatorAProcess = () -> {
			elevatorA.run();
		};

		Runnable elevatorBProcess = () -> {
			elevatorB.run();
		};
		
		serviceA.execute(elevatorAProcess);
		serviceB.execute(elevatorBProcess);
	}
	
	public void stop() {
		serviceA.shutdown();
		serviceB.shutdown();
	}
}
