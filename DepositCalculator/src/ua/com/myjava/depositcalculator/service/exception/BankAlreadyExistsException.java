package ua.com.myjava.depositcalculator.service.exception;

public class BankAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4031346128258698247L;
	
	public BankAlreadyExistsException(String message) {
		super(message);
	}
}
