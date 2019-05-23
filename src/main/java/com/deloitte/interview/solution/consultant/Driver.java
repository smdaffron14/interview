package com.deloitte.interview.solution.consultant;

public class Driver {

	public static void main(String[] args) {
		Elevator elevator = new Elevator(18);
		elevator.addStopRequest(5);
		elevator.addStopRequest(9);
		elevator.addStopRequest(2);
	}
}
