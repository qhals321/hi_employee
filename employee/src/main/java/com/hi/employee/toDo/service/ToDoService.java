package com.hi.employee.toDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.employee.employee.EmployeeVO;
import com.hi.employee.toDo.ToDoVO;
import com.hi.employee.toDo.dao.ToDoDao;

@Service
public class ToDoService implements IToDoService{

	@Autowired
	ToDoDao dao;
	
	@Override
	public void toDoInsert(ToDoVO toDo, EmployeeVO employee) {
	
		int result = dao.toDoInsert(toDo, employee);
		if(result==0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
	}
	
	@Override
	public List<ToDoVO> toDoSelect(EmployeeVO employee) {
		List<ToDoVO> toDos = dao.toDoSelect(employee);
		return toDos;
	}
	
	@Override
	public void toDoUpdate(ToDoVO toDo) {
		int result = dao.toDoUpdate(toDo);
		
	}
	
	@Override
	public List<ToDoVO> toDoSelectbyName(String name) {
		List<ToDoVO> toDoList=dao.toDoSelectbyName(name);
		return toDoList;
	}
	
	@Override
	public List<ToDoVO> toDoSelectAll() {
		List<ToDoVO> toDoList=dao.toDoSelectAll();
		return toDoList;
	}
	
}
