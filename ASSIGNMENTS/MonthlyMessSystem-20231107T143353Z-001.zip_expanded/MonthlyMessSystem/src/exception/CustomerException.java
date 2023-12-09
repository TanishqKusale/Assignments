package exception;

import java.util.Arrays;

public class CustomerException extends Exception{

	public CustomerException(String message) {
		super(message);
		
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
	
	

}
