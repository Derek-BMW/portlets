package ua.com.myjava.depositcalculator.mvc.form;

import java.io.Serializable;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Range;

@SuppressWarnings("serial")
public class InterestRequestData implements Serializable {
	@Digits(integer = 6, fraction = 2, message = "error.sum")
	@Range(min = 0, message = "error.sum")
	private String sum;
	@Digits(integer = 2, fraction = 0, message = "error.period")
	@Range(min = 1, message = "error.period")
	private String period;

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getPeriodAsInt() {
		return Integer.parseInt(period);
	}

	public double getSumAsDouble() {
		return Double.parseDouble(sum);
	}

	@Override
	public String toString() {
		return "CalculateInterestsForm [sum=" + sum + ", period=" + period + "]";
	}

}
