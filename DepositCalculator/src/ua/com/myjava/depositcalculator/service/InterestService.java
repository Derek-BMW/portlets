package ua.com.myjava.depositcalculator.service;

import java.util.List;

import ua.com.myjava.depositcalculator.service.dto.Interest;

public interface InterestService {
	/**
	 * Calculates deposit income for specified period for specified sum of money. If depositSum is negative - zero will
	 * be returned.
	 * 
	 * @param depositSum
	 *            - sum of money for deposit
	 * @param months
	 *            - period of deposit in months
	 * @return - list of incomes for deposit plan of available in database banks.
	 */
	public List<Interest> calcDepositInterestForPeriodInMonths(double depositSum, int months);
}
