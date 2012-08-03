package ua.com.myjava.depositcalculator.service.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Interest implements Serializable {
	private Long bankId;
	private String bankName;
	private double percent;
	private String depositName;
	private double value;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public String getDepositName() {
		return depositName;
	}

	public void setDepositName(String depositName) {
		this.depositName = depositName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Interest [bankName=" + bankName + ", percent=" + percent
				+ ", depositName=" + depositName + ", value=" + value + "]";
	}
}
