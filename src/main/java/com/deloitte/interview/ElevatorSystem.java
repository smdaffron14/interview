package com.deloitte.interview;

/**
 * A wrapper class that encapsulates all {@link Elevator}s in the
 * system. (Currently one for this example)
 * 
 * @author MD
 */
public class ElevatorSystem {

	private Elevator elevatorA;
	private Elevator elevatorB;

	ElevatorSystem(int numberOfFloors) {
		// Both elevators serve all floors
		elevatorA = new Elevator(numberOfFloors);
		elevatorB = new Elevator(numberOfFloors);
	}

	/**
	 * Initiates a floor request to the elevator(s)
	 * 
	 * @param destinationFloorNumber
	 */
	public void call(int destinationFloorNumber) {
		
		if (!elevatorA.isRunning()) {
			elevatorA.addFloorRequest(destinationFloorNumber);
		}
		else if (!elevatorB.isRunning()) {
			elevatorB.addFloorRequest(destinationFloorNumber);
		}
		else {
			// Both elevators are running, determine which elevator
			// is going to be closest to the requested floor
			int distanceA = Math.abs(elevatorA.getLastRequestedFloor() 
					- destinationFloorNumber);
			int distanceB = Math.abs(elevatorB.getLastRequestedFloor() 
					- destinationFloorNumber);
			
			int shortestDistance = Math.min(distanceA, distanceB);
			
			if (shortestDistance == distanceA) {
				elevatorA.addFloorRequest(destinationFloorNumber);
			} else {
				elevatorB.addFloorRequest(destinationFloorNumber);
			}
		}
	}
}
