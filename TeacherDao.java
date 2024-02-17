package com.jsp.jdbc_prepared_crud_with_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.jsp.jdbc_prepared_crud_with_architecture.connection.TeacherConnection;
import com.jsp.jdbc_prepared_crud_with_architecture.entity.Teacher;

public class TeacherDao {

	Connection connection = TeacherConnection.getTeacherConnection();

	/*
	 * insert Teacher Methods
	 */
	public Teacher saveTeacherDao(Teacher teacher) {

		String insertQuery = "insert into teacher values(?,?,?,?)";

		try {

			PreparedStatement ps = connection.prepareStatement(insertQuery);
			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getName());
			ps.setString(3, teacher.getEmail());
			ps.setObject(4, teacher.getDob());
			ps.execute();
			return teacher;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * getTeacherById methods
	 */
	public Teacher getTeacherByIdDao(int teacherId) {

		String selectQuery = "select * from teacher where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, teacherId);
				 
			ResultSet resultSet=ps.executeQuery();
			
			if(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				
				return new Teacher(id, name, email, dob);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * deleteTeacherById methods
	 */
	public int deleteTeacherByIdDao(int teacherId) {
		
		String deleteQuery = "delete from teacher where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setInt(1, teacherId);
				 
			return ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
