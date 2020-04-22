package com.hi.employee.commute.dao;

import java.util.List;

import com.hi.employee.commute.CommuteVO;

public interface ICommuteDao {
	
	int checkIn(int id);

	int checkOut(int id);
	
	void showLogAll();
	
	List<CommuteVO> logList();
	
	
	List<CommuteVO> logListById(int id);
	

}
