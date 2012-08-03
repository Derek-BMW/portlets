package ua.com.myjava.depositcalculator.mvc.form;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PreferencesData implements Serializable{
	private Double minPercent;

	public Double getMinPercent() {
		return minPercent;
	}

	public void setMinPercent(Double minPercent) {
		this.minPercent = minPercent;
	}
}
