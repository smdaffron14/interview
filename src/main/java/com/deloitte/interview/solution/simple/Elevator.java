package com.deloitte.interview.solution.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a simple solution to the
 * Elevator Conundrum CDT technical interview problem.
 * 
 * @author MD 
 */
public class Elevator {
	private List<Floor> floors;
	private int numFloors;
	
	private boolean doRun = false;

	public Elevator(int numFloors) {
		floors = new ArrayList<>();
		this.numFloors = numFloors;

		for (int i = 0; i < this.numFloors; i++) {
			Floor floor = new Floor(i);
			floors.add(floor);
		}
	}

	public void addFloorStop(int floorNumber) {
		floors.get(floorNumber).setStopRequested(true);
	}
	
	private void stopAtFloor(int floorNumber) {
		System.out.println(String.format("This is floor %s. Doors opening.",
				floorNumber));
		System.out.println("Closing doors.");
		
		floors.get(floorNumber).setStopRequested(false);
	}
	
	public void run() {
		doRun = true;
		
		while (doRun) {
			System.out.println("Going up!");
			for (int i = 0; i < numFloors; i++) {
				if (floors.get(i).isStopRequested()) {
					stopAtFloor(i);
				}
			}

			System.out.println("Going down!");
			for (int i = numFloors - 1; i >= 0; i--) {
				if (floors.get(i).isStopRequested()) {
					stopAtFloor(i);
				}
			}
		}
	}
	
	public void stop() {
		doRun = false;
	}
}
