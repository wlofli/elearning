package wolf.cfg.hbm;

// Generated 2014-2-15 20:31:44 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ElUser generated by hbm2java
 */
public class ElUser implements java.io.Serializable {

	private String eluserId;
	private String eluserLoginname;
	private String eluserPassword;
	private Integer eluserIslock;
	private String eluserClass;
	private Integer eluserIdentity;
	private String eluserReverse1;
	private String eluserReverse2;
	private String eluserName;
	private String eluserPhone;
	private String eluserEmail;
	private Date eluserDate;

	public ElUser() {
	}

	public ElUser(String eluserId) {
		this.eluserId = eluserId;
	}

	public ElUser(String eluserId, String eluserLoginname,
			String eluserPassword, Integer eluserIslock, String eluserClass,
			Integer eluserIdentity, String eluserReverse1,
			String eluserReverse2, String eluserName, String eluserPhone,
			String eluserEmail, Date eluserDate) {
		this.eluserId = eluserId;
		this.eluserLoginname = eluserLoginname;
		this.eluserPassword = eluserPassword;
		this.eluserIslock = eluserIslock;
		this.eluserClass = eluserClass;
		this.eluserIdentity = eluserIdentity;
		this.eluserReverse1 = eluserReverse1;
		this.eluserReverse2 = eluserReverse2;
		this.eluserName = eluserName;
		this.eluserPhone = eluserPhone;
		this.eluserEmail = eluserEmail;
		this.eluserDate = eluserDate;
	}

	public String getEluserId() {
		return this.eluserId;
	}

	public void setEluserId(String eluserId) {
		this.eluserId = eluserId;
	}

	public String getEluserLoginname() {
		return this.eluserLoginname;
	}

	public void setEluserLoginname(String eluserLoginname) {
		this.eluserLoginname = eluserLoginname;
	}

	public String getEluserPassword() {
		return this.eluserPassword;
	}

	public void setEluserPassword(String eluserPassword) {
		this.eluserPassword = eluserPassword;
	}

	public Integer getEluserIslock() {
		return this.eluserIslock;
	}

	public void setEluserIslock(Integer eluserIslock) {
		this.eluserIslock = eluserIslock;
	}

	public String getEluserClass() {
		return this.eluserClass;
	}

	public void setEluserClass(String eluserClass) {
		this.eluserClass = eluserClass;
	}

	public Integer getEluserIdentity() {
		return this.eluserIdentity;
	}

	public void setEluserIdentity(Integer eluserIdentity) {
		this.eluserIdentity = eluserIdentity;
	}

	public String getEluserReverse1() {
		return this.eluserReverse1;
	}

	public void setEluserReverse1(String eluserReverse1) {
		this.eluserReverse1 = eluserReverse1;
	}

	public String getEluserReverse2() {
		return this.eluserReverse2;
	}

	public void setEluserReverse2(String eluserReverse2) {
		this.eluserReverse2 = eluserReverse2;
	}

	public String getEluserName() {
		return this.eluserName;
	}

	public void setEluserName(String eluserName) {
		this.eluserName = eluserName;
	}

	public String getEluserPhone() {
		return this.eluserPhone;
	}

	public void setEluserPhone(String eluserPhone) {
		this.eluserPhone = eluserPhone;
	}

	public String getEluserEmail() {
		return this.eluserEmail;
	}

	public void setEluserEmail(String eluserEmail) {
		this.eluserEmail = eluserEmail;
	}

	public Date getEluserDate() {
		return this.eluserDate;
	}

	public void setEluserDate(Date eluserDate) {
		this.eluserDate = eluserDate;
	}

}
