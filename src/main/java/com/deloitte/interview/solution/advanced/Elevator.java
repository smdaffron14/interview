package com.deloitte.interview.solution.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents an elevator bearing a Map of
 * floors which it serves and its related active floor stop
 * requests
 * 
 * @author MD
 */
public class Elevator {
	private static final int MAX_RIDERS = 5;
	
	private Map<Floor, List<StopRequest>> floorsToRequestsMap = new ConcurrentHashMap<>();
	private int currentFloor = 1; // start on the first floor
	private int riderCount = 0;
	
	private int maxFloor;

	public Elevator(int floorCount) {
		for (int i = 1; i <= floorCount; i++) {
			Floor floor = new Floor(i);
			floorsToRequestsMap.put(floor, new ArrayList<>());
		}
		maxFloor = floorCount;
	}

	/**
	 * Returns the current floor of the elevator
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}

	/**
	 * This method associates a new stop request to the specified floor.
	 * This will tell the elevator to stop and open its doors when it reaches
	 * the floor
	 */
	public void addFloorRequest(Floor floor, StopRequest request) {
		floorsToRequestsMap.get(floor).add(request);
	}
	
	/**
	 * Returns a {@link Floor} for the given floor number
	 */
	public synchronized Floor getFloorByNumber(int number) {
		return floorsToRequestsMap.keySet().stream()
			.filter(f -> f.getNumber() == number)
			.findFirst()
			.get();
	}

	/**
	 * Starts the elevator traversal process by going up to start
	 * then traversing back down.
	 */
	public void run() {
		while (true) {
			for (int i = currentFloor; i <= maxFloor; i++) {
				currentFloor = i;
				stopAtFloor();
			}
			// Now traverse back down
			for (int i = currentFloor; i >= 1; i--) {
				currentFloor = i;
				stopAtFloor();
			}
		}
	}
	
	private void stopAtFloor() {
		List<StopRequest> stopsFulfilled = new ArrayList<>();

		List<StopRequest> stopsRequested = floorsToRequestsMap
				.get(getFloorByNumber(currentFloor));
		
		if (stopsRequested.isEmpty()) {
			// Nothing to see here, folks
			return;
		}
		
		stopsRequested.stream().forEach(request -> {
			switch (request.getType()) {
			case ENTER: 
				// Only pick up rider if he can fit
				if (riderCount < MAX_RIDERS) {
					openAndCloseDoor();
					riderCount++;
					stopsFulfilled.add(request);
				}
				break;
			case EXIT:
				openAndCloseDoor();
				riderCount--;
				stopsFulfilled.add(request);
				break;
			}
		});
		
		// Remove the stop requests that we have fulfilled
		stopsRequested.removeAll(stopsFulfilled);
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
				currentFloor));
	}
	
	private void close() {
		System.out.println("Door is closing");
	}
}
