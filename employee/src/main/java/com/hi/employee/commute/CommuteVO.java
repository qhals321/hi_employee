package com.hi.employee.commute;

public class CommuteVO {
	private int commuteId;
	private String checkIn;
	private String checkOut;
	private int employeeId;
	private String emName;
	
	
	
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public int getCommuteId() {
		return commuteId;
	}
	public void setCommuteId(int commuteId) {
		this.commuteId = commuteId;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	
	
}
