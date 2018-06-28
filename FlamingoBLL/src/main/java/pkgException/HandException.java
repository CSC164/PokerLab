package pkgException;

import pkgCore.Hand;

public class HandException extends Exception {

	private Hand HandState;

	public HandException() {
		super();
	}

	public HandException(String arg0, Hand hand) {
		super(arg0);
		this.HandState = hand;
	}

	public Hand getHandState() {
		return HandState;
	}
	
	
	
}
