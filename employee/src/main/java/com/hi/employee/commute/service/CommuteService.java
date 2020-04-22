package com.hi.employee.commute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.employee.commute.CommuteVO;
import com.hi.employee.commute.dao.CommuteDao;

@Service
public class CommuteService implements ICommuteService{
	
	@Autowired
	CommuteDao dao;
	
	@Override
	public void checkIn(int id) {
		System.out.println("service" + id);
		dao.checkIn(id);	
	}
	
	@Override
	public void checkOut(int id) {
		dao.checkOut(id);
	}
	
@Override
public List<CommuteVO> commuteList() {
	List<CommuteVO> commuteList = dao.logList();
	
	return commuteList;
}
}
