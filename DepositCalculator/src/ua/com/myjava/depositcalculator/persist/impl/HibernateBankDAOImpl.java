package ua.com.myjava.depositcalculator.persist.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.myjava.depositcalculator.model.Bank;
import ua.com.myjava.depositcalculator.persist.BankDAO;

@Transactional
@Repository("bankDAO")
public class HibernateBankDAOImpl implements BankDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Bank> getBanks() {
		return sessionFactory.getCurrentSession().createQuery("from Bank").list();
	}

	public void addBank(Bank bank) {
		sessionFactory.getCurrentSession().save(bank);

	}

	public Bank getBank(Long id) {
		return (Bank) sessionFactory.getCurrentSession().get(Bank.class, id);
	}
}
