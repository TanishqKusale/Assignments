package com.exception;

public class DoctorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8851471160829907201L;

	public DoctorException(String message) {
		super(message);
		
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	

}
