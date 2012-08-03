package ua.com.myjava.depositcalculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.model.Deposit;
import ua.com.myjava.depositcalculator.persist.BankDAO;
import ua.com.myjava.depositcalculator.persist.DepositDAO;
import ua.com.myjava.depositcalculator.service.BankService;
import ua.com.myjava.depositcalculator.service.exception.BankAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.DepositAlreadyExistsException;
import ua.com.myjava.depositcalculator.service.exception.UserNotLoggedInException;

@Service(value = "bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private DepositDAO depositDAO;

	@Transactional
	public void addBank(Bank bank, String user) throws BankAlreadyExistsException, UserNotLoggedInException {
		if (user == null || "".equals(user)) {
			throw new UserNotLoggedInException("Please login to add book");
		}
		bank.setCreatedBy(user);
		bankDAO.addBank(bank); // TODO check for uniqueness
	}

	@Transactional(readOnly = true)
	public List<Bank> getBanks() {
		return bankDAO.getBanks();
	}

	@Override
	public Bank findBankById(long bankId) {
		return bankDAO.getBank(bankId);
	}

	@Override
	public void addBankDeposit(Deposit deposit, String user) throws DepositAlreadyExistsException,
			UserNotLoggedInException {
		if (user == null || "".equals(user)) {
			throw new UserNotLoggedInException("Please login to add book");
		}
		deposit.setCreatedBy(user);
		depositDAO.addDeposit(deposit);// TODO check for uniqueness
	}
}
