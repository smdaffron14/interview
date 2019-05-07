package com.deloitte.interview;

import com.deloitte.interview.Floor;

/**
 * This class is a doubly-linked list of Floors leveraged in
 * the {@link Elevator} class.
 * 
 * @author MD
 */
public class Floor {

	private int number;
	private Floor next;
	private Floor prev;

	public Floor(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public Floor next() {
		return this.next;
	}

	public Floor prev() {
		return this.prev;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	public boolean hasPrev() {
		return this.prev != null;
	}
	
	public void setNext(Floor floor) {
		this.next = floor;
	}
	
	public void setPrev(Floor floor) {
		this.prev = floor;
	}
}
