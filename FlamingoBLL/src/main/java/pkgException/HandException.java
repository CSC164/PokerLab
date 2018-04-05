package pkgException;

import pkgCore.Hand;

public class HandException extends Exception {

	private Hand HandState;

	public HandException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HandException(String arg0, Hand hand) {
		super(arg0);
		this.HandState = hand;
	}

	public Hand getHandState() {
		return HandState;
	}
	
	
	
}
