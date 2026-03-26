package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Enrollment;

public class EnrollmentDAO {

	Connection connection;

	public EnrollmentDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	//CREATE RECORD ENROLLMENT
	public void insertEnrollment(Enrollment enrollment) {
		String insertSQL="INSERT INTO enrollment (student_id,course_id,enrollment_date)value(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, enrollment.getStudent_id());
			preparedStatement.setInt(2, enrollment.getCourse_id());
			preparedStatement.setDate(3,new java.sql.Date(enrollment.getEnrollment_date().getTime()));
			
			preparedStatement.executeUpdate();
			System.out.println("Record Inserted successfully!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	//READ RECORD
	public void readEnrollment() {
		String readSQL="SELECT * FROM enrollment";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readSQL);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("enrollment_id")+ " | "+
						resultSet.getInt("student_id")+ " | "+
						resultSet.getInt("course_id")+ " | "+
						resultSet.getDate("enrollment_date")
						);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	// update enrollments
	public void changeCourses(int id, int newCourseid) {
		String updatrSQL="UPDATE enrollment SET course_id=? WHERE SET id=? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updatrSQL);
			preparedStatement.setInt(1, newCourseid);
			preparedStatement.setInt(2, id);
			int row=preparedStatement.executeUpdate();
			if(row>0)System.out.println("cource Update successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEnrollment(int Eid) {
		String deleteSQL="DELETE FROM enrollment WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, Eid);
			preparedStatement.executeUpdate();
			System.out.println("Delete Enrollment Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
