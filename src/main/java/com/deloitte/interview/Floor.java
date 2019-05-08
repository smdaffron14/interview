package com.deloitte.interview;

import com.deloitte.interview.Floor;

/**
 * This class represents a floor in a building as leveraged in
 * the {@link Elevator} class.
 * 
 * @author MD
 */
public class Floor {

	private int number;

	public Floor(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}
}
