package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends RuntimeException {

	/**
	 * 
	 */
	private final double availableBalance;
	private final double requestedAmount;
	private static final long serialVersionUID = -1159808475879283028L;
	
	public NotEnoughFoundsException(double requestedAmount, double availableBalance) {
		super();
		this.availableBalance = availableBalance;
		this.requestedAmount = requestedAmount;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	public String toString() {
		return "Accountant balance is " + this.availableBalance + ", can't get " + this.requestedAmount;
	}
}
