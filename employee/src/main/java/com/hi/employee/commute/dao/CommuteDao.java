package com.hi.employee.commute.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hi.employee.commute.CommuteVO;
import com.hi.employee.employee.EmployeeVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Repository
public class CommuteDao implements ICommuteDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public CommuteDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		
	}
	
	
	
	
	@Override
	public int checkIn(int id) {
		System.out.println("dao" + id);
		String checkIn = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분").format(new Date());
		int result=0;
		
		final String sql = "INSERT INTO COMMUTE(CHECK_IN, EMPLOYEE_ID)"
				+ "VALUES(?,?)";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, checkIn);
				ps.setInt(2, id);
				

			}
		});

		
		return result;	
	}
	@Override
	public int checkOut(int id) {
			String checkOut = new SimpleDateFormat("yyyy년 MM월 dd일  HH시 mm초").format(new Date());
			int result=0;
			
			final String sql = "UPDATE COMMUTE SET(CHECK_OUT)=(?) WHERE EMPLOYEE_ID=? AND CHECK_OUT IS NULL";
			
			result = template.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, checkOut);
					ps.setInt(2, id);

				}
			});

			
			return result;	
	}
	
	@Override
	public void showLogAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<CommuteVO> logList() {
		List<CommuteVO> commuteList = null;
		
		final String sql = "SELECT e.NAME, c.check_in, c.check_out, c.COMMUTE_ID FROM COMMUTE c, EMPLOYEE e WHERE c.EMPLOYEE_ID = e.EMPLOYEE_ID";
		
		commuteList =  template.query(sql, new Object[] {}, new RowMapper<CommuteVO>() {

			@Override
			public CommuteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommuteVO commute = new CommuteVO();
				commute.setEmName(rs.getString("NAME"));
				commute.setCheckIn(rs.getString("CHECK_IN"));
				commute.setCheckOut(rs.getString("CHECK_OUT"));
				commute.setCommuteId(rs.getInt("COMMUTE_ID"));
				return commute;
			}
});
		
		if(commuteList.isEmpty()) 
			return null;
		
		return commuteList;	
	}

	
	@Override
	public List<CommuteVO> logListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
