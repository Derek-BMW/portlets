package ua.com.myjava.depositcalculator.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Deposit extends AuditFields {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private Double percent;
	@Column
	private Integer period;
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(nullable = false, name = "bank_id")
	private Bank bank;

	private Deposit(Bank bank, String title, double percent, int period) {
		this.bank = bank;
		this.title = title;
		this.percent = percent;
		this.period = period;
	}

	private Deposit() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public static class DepositBuilder {
		private Bank bank;
		private double percent;
		private int period;
		private String title;

		public DepositBuilder forBank(Bank bank) {
			this.bank = bank;
			return this;
		}

		public DepositBuilder withPercent(double percent) {
			this.percent = percent;
			return this;
		}

		public DepositBuilder forPeriod(int period) {
			this.period = period;
			return this;
		}

		public DepositBuilder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Deposit create() {
			return new Deposit(bank, title, percent, period);
		}

	}

	@Override
	public String toString() {
		return "Deposit [title=" + title + ", percent=" + percent + ", period=" + period + "]";
	}

}
