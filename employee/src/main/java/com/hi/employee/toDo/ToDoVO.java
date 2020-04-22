package com.hi.employee.toDo;

public class ToDoVO {
	private int toDoID;
	private String toDo;
	private String toDoDate;
	private int toDoCheck;
	private String emName;
	
	
	
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public int getToDoID() {
		return toDoID;
	}
	public void setToDoID(int toDoID) {
		this.toDoID = toDoID;
	}
	
	public String getToDo() {
		return toDo;
	}
	public void setToDo(String toDo) {
		this.toDo = toDo;
	}
	public String getToDoDate() {
		return toDoDate;
	}
	public void setToDoDate(String toDoDate) {
		this.toDoDate = toDoDate;
	}
	public int getToDoCheck() {
		return toDoCheck;
	}
	public void setToDoCheck(int toDoCheck) {
		this.toDoCheck = toDoCheck;
	}
	

}
