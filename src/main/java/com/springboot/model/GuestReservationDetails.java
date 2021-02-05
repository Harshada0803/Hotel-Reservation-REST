package com.springboot.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name="guest_reservation_details")
public class GuestReservationDetails {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="reservation_id")
	 private long reservationId;

	  @ManyToOne
	  @JoinColumn(name = "guest_id")
	  private Guest guest;

	  @Column(name = "start_date")
	   private Date startDate;
	  
	  @Column(name = "end_date")
	  private Date endDate;
	  
	  @Column(name="guest_age")
	  private int guestAge;
	  
	  @Column(name="total_Amount")
	  private long totalAmount;
	  
	  @Column(name="total_days")
	  private long totalDays;
	  
	  
	  
	  

	public GuestReservationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuestReservationDetails(long reservationId, Guest guest, Date startDate, Date endDate, int guestAge,
			long totalAmount, long totalDays) {
		super();
		this.reservationId = reservationId;
		this.guest = guest;
		this.startDate = startDate;
		this.endDate = endDate;
		this.guestAge = guestAge;
		this.totalAmount = totalAmount;
		this.totalDays = totalDays;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getGuestAge() {
		return guestAge;
	}

	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(long totalDays) {
		this.totalDays = totalDays;
	}

	@Override
	public String toString() {
		return "GuestReservationDetails [reservationId=" + reservationId + ", guest=" + guest + ", startDate="
				+ startDate + ", endDate=" + endDate + ", guestAge=" + guestAge + ", totalAmount=" + totalAmount
				+ ", totalDays=" + totalDays + "]";
	}
	  
	  
	  


}
