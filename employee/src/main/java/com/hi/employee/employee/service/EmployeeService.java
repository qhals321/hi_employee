package com.hi.employee.employee.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.employee.employee.EmployeeVO;
import com.hi.employee.employee.dao.EmployeeDao;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	EmployeeDao dao;
	
	
	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void employeeInsert(EmployeeVO employee) {
		System.out.println("Service 시작");
	int result=dao.employeeInsert(employee);
	
	if(result==0) {
		System.out.println("실패");
	} else {
		System.out.println("성공");
	}
	
	}
	

	
	@Override
	public void employeeDelete(EmployeeVO employee) {
		dao.employyDelete(employee);
		
		
	}
	
	@Override
	public EmployeeVO employeeSelectByID(EmployeeVO employee) {
		employee=dao.employeeSelectByID(employee);
		
		return employee;
	}
	
	@Override
	public List<EmployeeVO> employeeSelectByName(EmployeeVO employee) {
		List<EmployeeVO> employees = dao.employeeSelectByName(employee);
		return employees;
	
	}
	
	@Override
	public void employeeUpdate(EmployeeVO employee) {
		int result = dao.employeeUpdate(employee);
	
		if(result==0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
		
	}



	@Override
	public List<EmployeeVO> employeeSelectAll() {
		List<EmployeeVO> employees = dao.employeeSelectAll();
		
		return employees;
	}

	
	@Override
	public void fingerInsert(EmployeeVO employee) throws JSONException, IOException {
		int result = dao.fingerPrintInsert(employee);
		
		if(result==0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
	}
	
	@Override
	public EmployeeVO readFinger(EmployeeVO employee) throws JSONException, IOException {
		employee=dao.fingerSearch(employee);
		return employee;
		
	}
	
	
	
	
	
}
