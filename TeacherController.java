package com.jsp.jdbc_prepared_crud_with_architecture.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.jdbc_prepared_crud_with_architecture.dao.TeacherDao;
import com.jsp.jdbc_prepared_crud_with_architecture.entity.Teacher;
import com.jsp.jdbc_prepared_crud_with_architecture.service.TeacherService;

public class TeacherController {

	public static void main(String[] args) {
		TeacherService service = new TeacherService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1.INSERT\n2.UPDATE\n3.DELETE\n4.Display\n5.GetTeacherById");
			System.out.println("enter your option");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("enter id");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				scanner.nextLine();
				System.out.println("enter email");
				String email = scanner.next();
				System.out.println("enter date of birth");
				System.out.println("enter year");
				int year = scanner.nextInt();
				System.out.println("enter month");
				int month = scanner.nextInt();
				System.out.println("enter day");
				int day = scanner.nextInt();

				LocalDate date = LocalDate.of(year, month, day);

				Teacher teacher = new Teacher(id, name, email, date);

				service.saveTeacherService(teacher);
			}
				break;
			case 3:{
				System.out.println("enter id to delete teacher data");
				int id = scanner.nextInt();
				int a=service.deleteTeacherByIdService(id);
				if(a==1) {
					System.out.println("deleted");
				}else {
					System.out.println("given id is not found....");
				}
			}break;
			case 5: {
				System.out.println("enter id to display teacher data");
				int id = scanner.nextInt();
				Teacher teacher=service.getTeacherByIdService(id);
				
				if(teacher!=null) {
					System.out.println(teacher);
				}else {
					System.out.println("please check sql query or given id is not found");
				}
			}
				break;
			default:
				throw new IllegalArgumentException("invalid input: " + ch);
			}
		}
	}
}
