package ua.com.myjava.depositcalculator.mvc.form;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Range;

public class DepositData {
	private String title;
	@Digits(integer = 6, fraction = 2, message = "error.percent")
	@Range(min = 0, message = "error.percent")
	private String percent;
	@Digits(integer = 2, fraction = 0, message = "error.period")
	@Range(min = 1, message = "error.period")
	private String period;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "DepositData [title=" + title + ", percent=" + percent + ", period=" + period + "]";
	}
}
