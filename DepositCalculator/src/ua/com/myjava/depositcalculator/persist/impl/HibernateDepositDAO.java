package ua.com.myjava.depositcalculator.persist.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.myjava.depositcalculator.model.Deposit;
import ua.com.myjava.depositcalculator.persist.DepositDAO;

@Transactional
@Repository("depositDAO")
public class HibernateDepositDAO implements DepositDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addDeposit(Deposit deposit) {
		sessionFactory.getCurrentSession().save(deposit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Deposit> getDeposits() {
		return sessionFactory.getCurrentSession().createQuery("from Deposit").list();
	}

}
