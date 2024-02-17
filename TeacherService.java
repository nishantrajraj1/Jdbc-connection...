package com.jsp.jdbc_prepared_crud_with_architecture.service;

import com.jsp.jdbc_prepared_crud_with_architecture.dao.TeacherDao;
import com.jsp.jdbc_prepared_crud_with_architecture.entity.Teacher;

public class TeacherService {

	TeacherDao dao = new TeacherDao();
	
	/*
	 * insert Teacher Methods
	 */
	public Teacher saveTeacherService(Teacher teacher) {
		
		int nameLength  = teacher.getName().length();
		int id = teacher.getId();
		
		if((nameLength<=8)&&(id<=9999)) {
			return dao.saveTeacherDao(teacher);
		}else {
			System.out.println("please pass name with 8 character or less and id 4 digits or less");
			return null;
		}	
	}
	
	/*
	 * getTeacherById methods
	 */
	public Teacher getTeacherByIdService(int teacherId) {
	
		return dao.getTeacherByIdDao(teacherId);
	}
	
	/*
	 * deleteTeacherById methods
	 */
	public int deleteTeacherByIdService(int teacherId) {
		return dao.deleteTeacherByIdDao(teacherId);
	}
}
