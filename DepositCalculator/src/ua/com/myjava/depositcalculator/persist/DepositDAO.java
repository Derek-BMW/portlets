package ua.com.myjava.depositcalculator.persist;

import java.util.List;

import ua.com.myjava.depositcalculator.model.Deposit;

public interface DepositDAO {

	void addDeposit(Deposit deposit);
	
	List<Deposit> getDeposits();
}
