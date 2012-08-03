package ua.com.myjava.depositcalculator.service;

import java.util.List;


import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.model.Deposit;
import ua.com.myjava.depositcalculator.service.exception.BankAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.DepositAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.UserNotLoggedInException;

public interface BankService {

	/**
	 * Adds bank to database
	 * 
	 * @param bank
	 *            - bank data
	 * @param user
	 *            - user who are adding bank
	 * @throws BankAlreadyExistsException
	 *             - if specified bank already present in db
	 * @throws UserNotLoggedInException
	 *             - if user is not logged in
	 */
	void addBank(Bank bank, String user) throws BankAlreadyExistsException, UserNotLoggedInException;

	/**
	 * Get list of banks
	 * 
	 * @return - list of available banks in system
	 */
	List<Bank> getBanks();

	/**
	 * Searches for bank by its id. Null if not found
	 * @param bankId - bank id
	 * @return - bank by id.
	 */
	Bank findBankById(long bankId);
	
	/**
	 * Adds deposit data to bank.
	 * @param deposit - deposit data
	 * @param user - user, who is performing operation
	 * @throws DepositAlreadyExistsException - if sepcified deposit already exists (by title)
	 * @throws UserNotLoggedInException - if user is not logged in to perform this operation
	 */
	void addBankDeposit(Deposit deposit, String user)throws DepositAlreadyExistsException, UserNotLoggedInException;
}
