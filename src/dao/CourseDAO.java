package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Course;

public class CourseDAO {
Connection connection;

public CourseDAO(Connection connection) {
	super();
	this.connection = connection;
}

//CREAT COURSES
public void insertCourses(Course courses) {
	String insertSQL ="INSERT INTO course(course_name,duration)VALUE(?,?)";
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
		preparedStatement.setString(1, courses.getCourse_name());
		preparedStatement.setInt(2, courses.getDuration());
		preparedStatement.executeUpdate();
		
		System.out.println("Course Created Successfully!");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		
	}
}

public void readCourses() {
	String readSQL = "SELECT*FROM course";
	
	try {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(readSQL);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id") + "  | "+
					 resultSet.getString("course_name")+ " | "+
					resultSet.getInt("duration"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
//UPDATE DURATION
public void courseDuration(int id ,int newDuration) {
	String updateSQL="UPDATE course SET duration=? WHERE id=?";
	
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, newDuration);
		preparedStatement.setInt(2, id);
		
		int row = preparedStatement.executeUpdate();
		if(row>0)System.out.println("Duration updated Successfully!");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

//DELETE COURSE
public void deleteCourse(int Cid) {
	String deleteSQL="DELETE FROM course WHERE id=?";
	
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, Cid);
		
		preparedStatement.executeUpdate();
		System.out.println("Delete Successfully!");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
