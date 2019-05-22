package com.deloitte.interview.solution.simple;

/**
 * This class represents a floor as unsed
 * in a simple solution to the Elevator Conundrum
 * CDT interview problem
 * 
 * @author MD
 */
public class Floor {
	private int number;
	private boolean stopRequested = false;
	
	public Floor(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public boolean isStopRequested() {
		return stopRequested;
	}
	
	public void setStopRequested(boolean requested) {
		stopRequested = requested;
	}
}
