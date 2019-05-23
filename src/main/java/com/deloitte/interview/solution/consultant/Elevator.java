package com.deloitte.interview.solution.consultant;

public class Elevator {
	private int currentFloor = 0;
	private int numFloors;
	
	public Elevator(int numFloors) {
		this.numFloors = numFloors;
	}
	
	public void addStopRequest(int requestedFloor) {
		if (requestedFloor > numFloors || requestedFloor < 0) {
			return; // invalid request
		}
		
		int distanceToTravel = requestedFloor - currentFloor;
		if (distanceToTravel == 0) {
			return; // Already at requested floor
		}
		
		for (int i = 0; i < Math.abs(distanceToTravel); i++) {
			currentFloor = (distanceToTravel > 0) ? currentFloor + 1 : currentFloor - 1;
			System.out.println(String.format("This is floor %s", currentFloor));
		}
		System.out.println("Arrived at requested floor. "
				+ "Opening doors.");
	}
}
