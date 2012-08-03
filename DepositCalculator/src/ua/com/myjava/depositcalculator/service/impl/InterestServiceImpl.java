package ua.com.myjava.depositcalculator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.myjava.depositcalculator.model.Deposit;
import ua.com.myjava.depositcalculator.persist.DepositDAO;
import ua.com.myjava.depositcalculator.service.InterestService;
import ua.com.myjava.depositcalculator.service.dto.Interest;

@Service(value = "interestService")
public class InterestServiceImpl implements InterestService {

	private static final int MONTHS_IN_YEAR = 12;
	@Autowired
	private DepositDAO depositDAO;

	@SuppressWarnings("serial")
	public List<Interest> calcDepositInterestForPeriodInMonths(final double depositSum, final int months) {
		List<Interest> interests = new ArrayList<Interest>();
		for (final Deposit deposit : depositDAO.getDeposits()) {
			if (deposit.getPeriod() != months) {
				continue;
			}
			Interest interest = new Interest() {
				{
					setBankId(deposit.getBank().getId());
					setBankName(deposit.getBank().getTitle());
					setDepositName(deposit.getTitle());
					setPercent(deposit.getPercent());
					setValue(depositSum * deposit.getPercent() / 100 / MONTHS_IN_YEAR * months);
				}
			};
			interests.add(interest);
		}
		return interests;
	}
}
