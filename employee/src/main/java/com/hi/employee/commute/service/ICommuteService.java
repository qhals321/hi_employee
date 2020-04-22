package com.hi.employee.commute.service;

import java.util.List;

import com.hi.employee.commute.CommuteVO;

public interface ICommuteService {
	
	public void checkIn(int id);
	public void checkOut(int id);
	
	public List<CommuteVO> commuteList();
	
	
}
