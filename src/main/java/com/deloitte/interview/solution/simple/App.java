package com.deloitte.interview.solution.simple;

import com.deloitte.interview.solution.simple.Elevator.Direction;

/**
 * Driver code to instantiate simple solution
 * to Elevator Conundrum CDT interview problem
 * 
 * @author MD
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		Elevator elevator = new Elevator(18);
		
		// Rider 1 from floor 2 => 6
		elevator.addFloorStop(2, Direction.UP);
		elevator.addFloorStop(6, Direction.UP);
		
		// Rider 2 from floor 5 => 10
		elevator.addFloorStop(5, Direction.UP);
		elevator.addFloorStop(10, Direction.UP);
		
		// Rider 3 from floor 12 => 9
		elevator.addFloorStop(12, Direction.DOWN);
		elevator.addFloorStop(9, Direction.DOWN);
		
		// Rider 4 from floor 14 => 16
		elevator.addFloorStop(14, Direction.UP);
		elevator.addFloorStop(16, Direction.UP);
		
		elevator.run();
	}
}
