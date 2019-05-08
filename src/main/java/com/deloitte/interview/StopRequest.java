package com.deloitte.interview;

/**
 * This class represents a request from a rider to stop at
 * a floor. This class details whether the passenger will
 * be entering or exiting
 * 
 * @author MD
 */
public class StopRequest {

	private RequestType type;
	
	public StopRequest(RequestType type) {
		this.type = type;
	}
	
	public RequestType getType() {
		return this.type;
	}
}
