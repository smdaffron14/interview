package com.deloitte.interview.solution.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements a simple solution to the
 * Elevator Conundrum CDT technical interview problem.
 * 
 * @author MD 
 */
public class Elevator {
	private List<Floor> floors;
	private Map<Integer, Direction> stops;
	private int numFloors;
	
	public Elevator(int numFloors) {
		floors = new ArrayList<>();
		stops = new HashMap<>();
		
		this.numFloors = numFloors;

		for (int i = 0; i < this.numFloors; i++) {
			Floor floor = new Floor(i);
			floors.add(floor);
		}
	}

	public void addFloorStop(int floorNumber, Direction direction) {
		stops.put(floorNumber, direction);
	}
	
	private void stopAtFloor(int floorNumber) {
		System.out.println(String.format("This is floor %s. Doors "
				+ "opening.", floorNumber));
		System.out.println("Closing doors.");
		
		stops.remove(floorNumber);
	}
	
	public void run() {
		boolean doRun = true;
		
		while (doRun) {
			System.out.println("Going up!");
			for (int i = 0; i < numFloors; i++) {
				if (Direction.UP == stops.get(i)) {
					stopAtFloor(i);
				}
			}

			System.out.println("Going down!");
			for (int i = numFloors - 1; i >= 0; i--) {
				if (Direction.DOWN == stops.get(i)) {
					stopAtFloor(i);
				}
			}
			doRun = stops != null && stops.size() > 0;
		}
	}
	
	public enum Direction {
		UP,
		DOWN,
	}
}
