package com.hi.employee.employee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hi.employee.employee.EmployeeVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Repository
public class EmployeeDao implements IEmployeeDao{
	
	private JdbcTemplate template;
	
	
	
	
	@Autowired
	public EmployeeDao(ComboPooledDataSource dataSource) {
		
		this.template = new JdbcTemplate(dataSource);
	}
	
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	@Override
	public int employeeInsert(EmployeeVO employee) {
		System.out.println("dao 시작");
		int result=0;
		
		final String sql = "INSERT INTO EMPLOYEE(NAME, POSITION, SECURITY_NUM,"
				+ " OPEN_TIME, CLOSE_TIME, START_DATE, END_DATE, STATUS, TEAM, PHONE) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getEmName());
				ps.setString(2, employee.getEmPosition());
				ps.setString(3, employee.getEmSecurityNum());
				ps.setString(4, employee.getEmOpenTime());
				ps.setString(5, employee.getEmCloseTime());
				ps.setString(6, employee.getEmStartDate());
				ps.setString(7, employee.getEmEndDate());
				ps.setInt(8, employee.getEmStatus());
				ps.setString(9, employee.getEmTeam());
				ps.setString(10, employee.getEmPhone());
			}
		});

		
		return result;
	}
	
	@Override
	public EmployeeVO employeeSelectByID(EmployeeVO employee) {
List<EmployeeVO> employees = null;
		
		final String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
		
		employees = template.query(sql, new Object[]{employee.getEmId()}, new RowMapper<EmployeeVO>() {

			@Override
			public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVO employee = new EmployeeVO();
				employee.setEmId(rs.getInt("EMPLOYEE_ID"));
				employee.setEmName(rs.getString("NAME"));
				employee.setEmPosition(rs.getString("POSITION"));
				employee.setEmSecurityNum(rs.getString("SECURITY_NUM"));
				employee.setEmOpenTime(rs.getString("OPEN_TIME"));
				employee.setEmCloseTime(rs.getString("CLOSE_TIME"));
				employee.setEmStartDate(rs.getString("START_DATE"));
				employee.setEmEndDate(rs.getString("END_DATE"));
				employee.setEmStatus(rs.getInt("STATUS"));
				employee.setEmTeam(rs.getString("TEAM"));
				employee.setEmPhone(rs.getString("PHONE"));
				employee.setEmFingerPrint(rs.getInt("FINGERPRINT"));
				return employee;
			}
			
		});
		
		if(employees.isEmpty()) 
			return null;
		
		return employees.get(0);
		
	}
	
	@Override
	public List<EmployeeVO> employeeSelectByName(EmployeeVO employee) {
		List<EmployeeVO> employees = null;

		final String sql = "SELECT * FROM EMPLOYEE WHERE NAME=?";
		
		employees = template.query(sql, new Object[]{employee.getEmName()}, new RowMapper<EmployeeVO>() {

			@Override
			public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVO employee = new EmployeeVO();
				employee.setEmId(rs.getInt("EMPLOYEE_ID"));
				employee.setEmName(rs.getString("NAME"));
				employee.setEmPosition(rs.getString("POSITION"));
				employee.setEmSecurityNum(rs.getString("SECURITY_NUM"));
				employee.setEmOpenTime(rs.getString("OPEN_TIME"));
				employee.setEmCloseTime(rs.getString("CLOSE_TIME"));
				employee.setEmStartDate(rs.getString("START_DATE"));
				employee.setEmEndDate(rs.getString("END_DATE"));
				employee.setEmStatus(rs.getInt("STATUS"));
				employee.setEmTeam(rs.getString("TEAM"));
				employee.setEmPhone(rs.getString("PHONE"));
				employee.setEmFingerPrint(rs.getInt("FINGERPRINT"));
				System.out.println("employee 완성");
				return employee;
			}
			
		});
		
		if(employees.isEmpty()) { 
			return null;}
		else {
		return employees;}
	}
	
	
	@Override
	public List<EmployeeVO> employeeSelectAll() {
		List<EmployeeVO> employees = null;

		final String sql = "SELECT * FROM EMPLOYEE";
		
		employees = template.query(sql, new Object[] {}, new RowMapper<EmployeeVO>() {

			@Override
			public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVO employee = new EmployeeVO();
				employee.setEmId(rs.getInt("EMPLOYEE_ID"));
				employee.setEmName(rs.getString("NAME"));
				employee.setEmPosition(rs.getString("POSITION"));
				employee.setEmSecurityNum(rs.getString("SECURITY_NUM"));
				employee.setEmOpenTime(rs.getString("OPEN_TIME"));
				employee.setEmCloseTime(rs.getString("CLOSE_TIME"));
				employee.setEmStartDate(rs.getString("START_DATE"));
				employee.setEmEndDate(rs.getString("END_DATE"));
				employee.setEmStatus(rs.getInt("STATUS"));
				employee.setEmTeam(rs.getString("TEAM"));
				employee.setEmPhone(rs.getString("PHONE"));
				employee.setEmFingerPrint(rs.getInt("FINGERPRINT"));
				return employee;
			}
			
		});
		
		if(employees.isEmpty()) 
			return null;
		
		return employees;		
	}
	
	
	
	
	@Override
	public int employeeUpdate(EmployeeVO employee) {
		int result=0;
		
		final String sql = "UPDATE EMPLOYEE SET NAME=?, POSITION=?, SECURITY_NUM=?,"
				+ "OPEN_TIME=?, CLOSE_TIME=?, START_DATE=?, END_DATE=?, STATUS=?, TEAM=?, PHONE=? "
				+ "WHERE EMPLOYEE_ID=?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getEmName());
				ps.setString(2, employee.getEmPosition());
				ps.setString(3, employee.getEmSecurityNum());
				ps.setString(4, employee.getEmOpenTime());
				ps.setString(5, employee.getEmCloseTime());
				ps.setString(6, employee.getEmStartDate());
				ps.setString(7, employee.getEmEndDate());
				ps.setInt(8, employee.getEmStatus());
				ps.setString(9, employee.getEmTeam());
				ps.setString(10, employee.getEmPhone());
				ps.setInt(11, employee.getEmId());
			}
		});

		
		return result;
	}
	
	
	
	
	@Override
	public int employyDelete(EmployeeVO employee) {
		int result = 0;
		
		final String sql = "DELETE member WHERE EMPLOYEE_ID = ?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, employee.getEmId());
			}
		});
		return 0;
	}


	
	@Override
	public int fingerPrintInsert(EmployeeVO employee) throws JSONException, IOException {
		int result=0;
		
		
		final String sql = "UPDATE EMPLOYEE SET FINGERPRINT=1 "
				+ "WHERE EMPLOYEE_ID=?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, employee.getEmId());
				
			}
		});

		
		return result;
	}


	@Override
	public EmployeeVO fingerSearch(EmployeeVO employee) throws JSONException, IOException {
List<EmployeeVO> employees = null;


		final String sql = "SELECT * FROM EMPLOYEE WHERE FINGERPRINT=?";
		
		employees = template.query(sql, new Object[]{employee.getEmFingerPrint()}, new RowMapper<EmployeeVO>() {

			@Override
			public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVO employee = new EmployeeVO();
				employee.setEmId(rs.getInt("EMPLOYEE_ID"));
				employee.setEmName(rs.getString("NAME"));
				employee.setEmPosition(rs.getString("POSITION"));
				employee.setEmSecurityNum(rs.getString("SECURITY_NUM"));
				employee.setEmOpenTime(rs.getString("OPEN_TIME"));
				employee.setEmCloseTime(rs.getString("CLOSE_TIME"));
				employee.setEmStartDate(rs.getString("START_DATE"));
				employee.setEmEndDate(rs.getString("END_DATE"));
				employee.setEmStatus(rs.getInt("STATUS"));
				employee.setEmTeam(rs.getString("TEAM"));
				employee.setEmPhone(rs.getString("PHONE"));
				employee.setEmFingerPrint(rs.getInt("FINGERPRINT"));
				return employee;
			}
			
		});
		
		if(employees.isEmpty()) 
			return null;
		
		return employees.get(0);

	
	}


	
	
}
