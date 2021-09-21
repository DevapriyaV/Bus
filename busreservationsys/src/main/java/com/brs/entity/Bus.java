package com.brs.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="busId")
	private int busId;
	@Column(name = "bus_name")
	private String busName;
	@Column(name = "driver_name")
	private String driverName;
	@Column(name = "bustype")
	private String busType;
	@Column(name = "routefrom")
	private String routeFrom;
	@Column(name = "routeto")
	private String routeTo;
	@JsonProperty("arrivalTime")
	@Column(name = "arrival_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime arrivalTime;
	@JsonProperty("depatureTime")
	@Column(name = "depatureTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime departureTime;
	@Column(name = "seats")
	private int seats;
	@Column(name = "availaseats")
	private int avaiableSeats;
	
	//@OneToOne(mappedBy = "bus")
	//private FeedBack feedBack;
	
	/*
	 * @OneToOne(mappedBy = "bus") private Reservation reservation;
	 * 
	 * 
	 * public FeedBack getFeedBack() { return feedBack; } public void
	 * setFeedBack(FeedBack feedBack) { this.feedBack = feedBack; }
	 * 
	 * 
	 * 
	 * public Reservation getReservation() { return reservation; } public void
	 * setReservation(Reservation reservation) { this.reservation = reservation; }
	 */
	
	 /* @OneToOne(mappedBy = "bus", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private FeedBack feedback;
	 * 
	 * @OneToOne(mappedBy = "bus", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private Reservation reservation;
	 */
	
	public int getBusId() {
		return busId;
	}
	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, int seats, int avaiableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public int getAvaiableSeats() {
		return avaiableSeats;
	}
	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busId != other.busId)
			return false;
		return true;
	}
	
}
