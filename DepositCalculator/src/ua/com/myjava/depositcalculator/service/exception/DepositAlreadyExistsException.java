package ua.com.myjava.depositcalculator.service.exception;

@SuppressWarnings("serial")
public class DepositAlreadyExistsException extends Exception {

	public DepositAlreadyExistsException(String message) {
		super(message);
	}
}
