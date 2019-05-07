package com.deloitte.interview;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	private Floor currentFloor;
	private List<Integer> requests = new ArrayList<>();
	private boolean running = false;

	public Elevator(int floorCount) {
		for (int i = 1; i <= floorCount; i++) {
			Floor floor = new Floor(i);
			initFloor(floor);
		}
	}

	private void initFloor(Floor floor) {
		if (currentFloor == null) {
			currentFloor = floor;
		} else {
			Floor existingFloor = currentFloor;
			while (existingFloor.hasNext()) {
				existingFloor = existingFloor.next();
			}

			// Add to the end of the floors linked list
			existingFloor.setNext(floor);
		}
	}

	/**
	 * Traverse the doubly-linked list of floors until we are at the right one
	 */
	private void travelToFloor(int to) {
		int currentFloorNumber = currentFloor.getNumber();

		if (to > currentFloorNumber) {
			while (currentFloor.getNumber() != to) {
				currentFloor = currentFloor.next();
			}
		} else if (to < currentFloorNumber) {
			while (currentFloor.getNumber() != to) {
				currentFloor = currentFloor.prev();
			}
		}
		openAndCloseDoor();
	}

	private void openAndCloseDoor() {
		open();
		try {
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			System.exit(0);
		}
		close();
	}
	
	private void open() {
		System.out.println(String.format(
				"This is floor %s. Door is opening", 
				currentFloor.getNumber()));
	}
	
	private void close() {
		System.out.println("Door is closing");
	}

	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public boolean isRunning() {
		return running;
	}
	
	/**
	 * This simple method adds the requested floor to the end of the queue. A strong
	 * candidate might elaborate on some logic to dynamically insert a new request
	 * at a more optimal point in the queue. (e.g. insert a new floor while the
	 * elevator is en-route to a nearby floor)
	 */
	public void addFloorRequest(int to) {
		requests.add(to);

		// Start elevator if it is not already running
		if (!running) {
			run();
		}
	}
	
	public int getLastRequestedFloor() {
		return requests.get(requests.size() - 1);
	}

	/**
	 * Starts the elevator traversal process. Allows the elevator to rest (remain at
	 * current floor) when no requests are active.
	 */
	public void run() {
		while (requests != null && requests.size() > 0) {
			running = true;

			// pull from front of queue
			int nextStop = requests.remove(0);
			travelToFloor(nextStop);
		}

		// We've processed all floor requests. Let elevator rest
		running = false;
	}
}
