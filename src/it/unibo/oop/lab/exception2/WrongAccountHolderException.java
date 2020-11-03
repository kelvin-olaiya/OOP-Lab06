package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends RuntimeException {

	/**
	 * 
	 */
	private final int unauthorizedUserID;
	private static final long serialVersionUID = 7190620326792084901L;
	
	public WrongAccountHolderException(int userID) {
		super();
		unauthorizedUserID = userID;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	public String toString() {
		return "User with id " + this.unauthorizedUserID + " is not the owner of the account";
	}

}
