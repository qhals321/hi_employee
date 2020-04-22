package com.hi.employee.toDo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hi.employee.employee.EmployeeVO;
import com.hi.employee.toDo.ToDoVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class ToDoDao implements IToDoDao{
	
	private JdbcTemplate template;
	
	
	@Autowired
	public ToDoDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public ToDoDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public int toDoInsert(ToDoVO toDo, EmployeeVO employee) {
int result=0;
		
		final String sql = "INSERT INTO TO_DO(EMPLOYEE_ID, TO_DO, TO_DO_DATE, TO_DO_CHECK)"
				+ "VALUES(?,?,?,0)";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, employee.getEmId());
				ps.setString(2, toDo.getToDo());
				ps.setString(3, toDo.getToDoDate());

			}
		});

		
		return result;
	}
	
	@Override
	public List<ToDoVO> toDoSelect(EmployeeVO employee) {
		List<ToDoVO> toDos=null;
		
		final String sql = "SELECT * FROM EMPLOYEE e, TO_DO d WHERE e.EMPLOYEE_ID = d.EMPLOYEE_ID and d.EMPLOYEE_ID=? order by TO_DO_DATE";
		toDos = template.query(sql, new Object[]{employee.getEmId()}, new RowMapper<ToDoVO>() {

			@Override
			public ToDoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ToDoVO toDo = new ToDoVO();
				toDo.setToDoID(rs.getInt("TO_DO_ID"));
				toDo.setToDo(rs.getString("TO_DO"));
				toDo.setToDoDate(rs.getString("TO_DO_DATE"));
				toDo.setToDoCheck(rs.getInt("TO_DO_CHECK"));
				toDo.setEmName(rs.getString("NAME"));
				return toDo;
	}
			
			
			
		});
		
		if(toDos.isEmpty()) 
			return null;
		
		return toDos;
	}
	
	@Override
	public List<ToDoVO> toDoSelectAll() {
		List<ToDoVO> toDos = null;

		final String sql ="SELECT * FROM EMPLOYEE e, TO_DO d WHERE e.EMPLOYEE_ID = d.EMPLOYEE_ID order by d.TO_DO_DATE";
		
		toDos = template.query(sql, new Object[]{}, new RowMapper<ToDoVO>() {

			@Override
			public ToDoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ToDoVO toDo = new ToDoVO();
				toDo.setToDoID(rs.getInt("TO_DO_ID"));
				toDo.setToDo(rs.getString("TO_DO"));
				toDo.setToDoDate(rs.getString("TO_DO_DATE"));
				toDo.setToDoCheck(rs.getInt("TO_DO_CHECK"));
				toDo.setEmName(rs.getString("NAME"));
				return toDo;
			}
			
		});
		
		if(toDos.isEmpty()) 
			return null;
		
		return toDos;		
	}

	
	@Override
	public int toDoUpdate(ToDoVO toDo) {
int result=0;
		
		final String sql = "UPDATE TO_DO SET TO_DO=?, TO_DO_DATE=?, TO_DO_CHECK=?"
				+ "WHERE TO_DO_ID=?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, toDo.getToDo());
				ps.setString(2, toDo.getToDoDate());
				ps.setInt(3, toDo.getToDoCheck());
				ps.setInt(4, toDo.getToDoID());
				
			}
		});

		
		return result;
	}
	
	@Override
	public List<ToDoVO> toDoSelectbyName(String name) {
List<ToDoVO> toDos=null;
		
		final String sql = "SELECT * FROM EMPLOYEE e, TO_DO d WHERE e.EMPLOYEE_ID = d.EMPLOYEE_ID and e.NAME = ? order by d.TO_DO_DATE";
		toDos = template.query(sql, new Object[]{name}, new RowMapper<ToDoVO>() {

			@Override
			public ToDoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ToDoVO toDo = new ToDoVO();
				toDo.setToDoID(rs.getInt("TO_DO_ID"));
				toDo.setToDo(rs.getString("TO_DO"));
				toDo.setToDoDate(rs.getString("TO_DO_DATE"));
				toDo.setToDoCheck(rs.getInt("TO_DO_CHECK"));
				toDo.setEmName(rs.getString("NAME")); 	
				return toDo;
	}
			
			
			
		});
		
		if(toDos.isEmpty()) 
			return null;
		
		return toDos;
	}

	
	
}
