package ua.com.myjava.depositcalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank extends AuditFields {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private String url;
	@Column(name = "logo_url")
	private String logoURL;

	public Bank(String title, String url, String logoURL) {
		super();
		this.title = title;
		this.url = url;
		this.logoURL = logoURL;
	}

	@SuppressWarnings("unused")
	private Bank() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "Bank [id=" + id + ", title=" + title + ", url=" + url + ", logoURL=" + logoURL + "]";
	}

}
