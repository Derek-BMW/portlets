package ua.com.myjava.depositcalculator.mvc.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
public class BankData implements Serializable{
	@NotEmpty
	private String title;
	private String url;
	private String logoURL;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	@Override
	public String toString() {
		return "BankData [title=" + title + ", url=" + url + ", logoURL=" + logoURL + "]";
	}

}
