package com.hi.employee.toDo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hi.employee.employee.EmployeeVO;
import com.hi.employee.toDo.ToDoVO;
import com.hi.employee.toDo.service.ToDoService;

import io.swagger.annotations.Api;

@RestController
@Api(value="APIs")
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;
	
	private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);
	
	
	@RequestMapping(value = "/toDo/name/{name}", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public Map toDoByName(@PathVariable String name) {
		
		//List<EmployeeVO> employeeList=employeeService.employeeSelectByName(name);
		List<ToDoVO> toDoList=toDoService.toDoSelectbyName(name);
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", toDoList);
		
		return result;
			}

	
	
	@RequestMapping(value = "/toDo", method = RequestMethod.POST, headers= {"Content-type=application/json"})
	public Map toDoInsert(@RequestBody EmployeeVO employee, ToDoVO toDo){
		if(employee!=null)
			toDoService.toDoInsert(toDo, employee);
		
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	
	
	@RequestMapping(value = "/toDo/{ID}", method = RequestMethod.GET)
	public Map toDoSelect(@PathVariable int ID) {
		EmployeeVO employee = new EmployeeVO();
		employee.setEmId(ID);
		List<ToDoVO> toDoList=toDoService.toDoSelect(employee);
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", toDoList);
		return result;
		}
	
	@RequestMapping(value="/toDo", method = RequestMethod.PUT, headers= {"Content-type=application/json"})
	public Map toDoUpdate(@RequestBody ToDoVO toDo){
		if(toDo!=null)
		toDoService.toDoUpdate(toDo);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		return result;
	}

	@RequestMapping(value = "/toDo", method = RequestMethod.GET)
	public Map toDoSelectAll() {
		List<ToDoVO> toDoList=toDoService.toDoSelectAll();
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", toDoList);
		return result;
		}
	
	
	

}

