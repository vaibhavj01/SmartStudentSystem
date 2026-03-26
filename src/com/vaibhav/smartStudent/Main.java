package com.vaibhav.smartStudent;

import java.sql.Connection;

import javax.xml.stream.events.StartDocument;

import dao.CourseDAO;
import dao.EnrollmentDAO;
import dao.StudentDAO;
import database.DatabaseUtil;

public class Main {
public static void main(String[] args) {
	
	Connection connection = DatabaseUtil.getConnection();
	
	StudentDAO studentDAO = new StudentDAO(connection);
	CourseDAO courseDAO = new CourseDAO(connection);
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO(connection);
	ConsoleUI.start(studentDAO,courseDAO,enrollmentDAO);
}
}
