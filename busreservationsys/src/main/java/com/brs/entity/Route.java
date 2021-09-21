package com.brs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Route {
	@Id
	private long routeId;
	private String routeFrom;
	private String routeTo;
	private int distance;
	@OneToMany(targetEntity = Bus.class)
	private List<Bus> bus;
	public long getRouteId() {
		return routeId;
	}
	public void setRouteId(long l) {
		this.routeId = l;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<Bus> getBus() {
		return bus;
	}
	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	
	
}