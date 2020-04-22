package com.hi.employee.toDo.dao;

import java.util.List;

import com.hi.employee.employee.EmployeeVO;
import com.hi.employee.toDo.ToDoVO;

public interface IToDoDao {
	
	int toDoInsert(ToDoVO toDo, EmployeeVO employee);
	
	int toDoUpdate(ToDoVO toDo);
	
	List<ToDoVO> toDoSelect(EmployeeVO employee);
	
	List<ToDoVO> toDoSelectAll();
	
	List<ToDoVO> toDoSelectbyName(String name);
	

}
