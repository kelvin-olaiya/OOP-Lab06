package it.unibo.oop.lab.exception1;

public class NoEnoughBatteryException extends IllegalStateException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1734193432184847442L;
	public NoEnoughBatteryException() {
	}
	
	public String toString() {
		return "Battery level too low for the operation to be executed";
	}
	public String getMessage() {
		return this.toString();
	}

}
