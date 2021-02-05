package com.springboot.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table
public class Guest {
	@Id
	@GeneratedValue
	@Column(name="guest_id")
	private long guestId;
	@Column(name="guest_first_name")
	private String guestFirstName;
	@Column(name="guest_last_name")
	private String guestLastName;
	@Column(name="guest_email_id")
	private String guestEmailId;
	@Column(name="guest_password")
	private String guestPassword;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="city_of_guest")
	private String cityOfGuest;
	
	
	
	
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Guest(long guestId, String guestFirstName, String guestLastName, String guestEmailId, String guestPassword,
			Date dateOfBirth, String cityOfGuest) {
		super();
		this.guestId = guestId;
		this.guestFirstName = guestFirstName;
		this.guestLastName = guestLastName;
		this.guestEmailId = guestEmailId;
		this.guestPassword = guestPassword;
		this.dateOfBirth = dateOfBirth;
		this.cityOfGuest = cityOfGuest;
	}




	public String getGuestEmailId() {
		return guestEmailId;
	}




	public void setGuestEmailId(String guestEmailId) {
		this.guestEmailId = guestEmailId;
	}




	public String getGuestPassword() {
		return guestPassword;
	}




	public void setGuestPassword(String guestPassword) {
		this.guestPassword = guestPassword;
	}




	public long getGuestId() {
		return guestId;
	}


	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}


	public String getGuestFirstName() {
		return guestFirstName;
	}


	public void setGuestFirstName(String guestFirstName) {
		this.guestFirstName = guestFirstName;
	}


	public String getGuestLastName() {
		return guestLastName;
	}


	public void setGuestLastName(String guestLastName) {
		this.guestLastName = guestLastName;
	}


	


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getCityOfGuest() {
		return cityOfGuest;
	}


	public void setCityOfGuest(String cityOfGuest) {
		this.cityOfGuest = cityOfGuest;
	}




	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestFirstName=" + guestFirstName + ", guestLastName=" + guestLastName
				+ ", guestEmailId=" + guestEmailId + ", guestPassword=" + guestPassword + ", dateOfBirth=" + dateOfBirth
				+ ", cityOfGuest=" + cityOfGuest + "]";
	}


	
	
	
	
	
	

}
