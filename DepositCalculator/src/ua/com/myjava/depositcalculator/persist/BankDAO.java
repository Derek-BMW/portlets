package ua.com.myjava.depositcalculator.persist;

import java.util.List;

import ua.com.myjava.depositcalculator.model.Bank;

public interface BankDAO {
	List<Bank> getBanks();

	void addBank(Bank bank);

	Bank getBank(Long id);
}
