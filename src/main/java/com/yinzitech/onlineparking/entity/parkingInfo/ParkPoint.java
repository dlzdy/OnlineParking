package com.yinzitech.onlineparking.entity.parkingInfo;

import java.io.Serializable;

public class ParkPoint implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String parkId;
	String parkName;
	String Lat;
	String Lng;
	String Lat1;
	String Lng1;
	String Lat2;
	String Lng2;
	String Lat3;
	String Lng3;
	public String getParkId() {
		return parkId;
	}
	public void setParkId(String parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLng() {
		return Lng;
	}
	public void setLng(String lng) {
		Lng = lng;
	}
	public String getLat1() {
		return Lat1;
	}
	public void setLat1(String lat1) {
		Lat1 = lat1;
	}
	public String getLng1() {
		return Lng1;
	}
	public void setLng1(String lng1) {
		Lng1 = lng1;
	}
	public String getLat2() {
		return Lat2;
	}
	public void setLat2(String lat2) {
		Lat2 = lat2;
	}
	public String getLng2() {
		return Lng2;
	}
	public void setLng2(String lng2) {
		Lng2 = lng2;
	}
	public String getLat3() {
		return Lat3;
	}
	public void setLat3(String lat3) {
		Lat3 = lat3;
	}
	public String getLng3() {
		return Lng3;
	}
	public void setLng3(String lng3) {
		Lng3 = lng3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Park [parkId=" + parkId + ", parkName=" + parkName + ", Lat=" + Lat + ", Lng=" + Lng + ", Lat1=" + Lat1
				+ ", Lng1=" + Lng1 + ", Lat2=" + Lat2 + ", Lng2=" + Lng2 + ", Lat3=" + Lat3 + ", Lng3=" + Lng3 + "]";
	}
	public ParkPoint(String parkId, String parkName, String lat, String lng, String lat1, String lng1, String lat2,
			String lng2, String lat3, String lng3) {
		super();
		this.parkId = parkId;
		this.parkName = parkName;
		Lat = lat;
		Lng = lng;
		Lat1 = lat1;
		Lng1 = lng1;
		Lat2 = lat2;
		Lng2 = lng2;
		Lat3 = lat3;
		Lng3 = lng3;
	}
	public ParkPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
