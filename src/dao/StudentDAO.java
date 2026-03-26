package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;

public class StudentDAO {

	Connection connection;

	public StudentDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	//CREATE : Create Student and Insert Records
	public void insertStudent(Student student) {
		String insertSQL = "INSERT INTO student(name,email,phone)value (?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1,student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getPhone());
			
			preparedStatement.executeUpdate();
			System.out.println("Student Created Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//READ STUDENTS RECORDS
	public void readStudent() {
		
		String readSQL = "SELECT*FROM student";
		
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readSQL);
			System.out.println("All Student List: ");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " | "+
								 resultSet.getString("name")+ " | "+
								resultSet.getString("email")+ " | "+
								 resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//UPDATE EMAILS
	public void updateStudentEmail(int id, String newEmail) {
		String updateMSQL = "UPDATE student SET email=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateMSQL);
			preparedStatement.setString(1, newEmail);
			preparedStatement.setInt(2, id);
			
			int row = preparedStatement.executeUpdate();
			if(row>0)System.out.println("Email Updated Successfull!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//DELETE STUDENT RECORDS
	public void deleteStudent(int Sid) {
		String deleteSQL = "DELETE FROM student WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
			
			preparedStatement.setInt(1, Sid);
			preparedStatement.executeUpdate();
			System.out.println("Delete Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Update student info (search by Roll No or Name)
	public void updateStudentBySearch(String searchType, String value, Student newData) {

	    try {
	        String selectSQL = "";

	        if (searchType.equalsIgnoreCase("id")) {
	            selectSQL = "SELECT * FROM student WHERE id=?";
	        } else if (searchType.equalsIgnoreCase("name")) {
	            selectSQL = "SELECT * FROM student WHERE name=?";
	        } else {
	            System.out.println("Invalid Search Type!");
	            return;
	        }

	        PreparedStatement selectPS = connection.prepareStatement(selectSQL);

	        if (searchType.equalsIgnoreCase("id")) {
	            selectPS.setInt(1, Integer.parseInt(value));
	        } else {
	            selectPS.setString(1, value);
	        }

	        ResultSet rs = selectPS.executeQuery();

	        if (rs.next()) {

	            int id = rs.getInt("id");

	            System.out.println("Student Found:");
	            System.out.println(rs.getInt("id") + " | " +
	                               rs.getString("name") + " | " +
	                               rs.getString("email") + " | " +
	                               rs.getString("phone"));

	            // UPDATE QUERY
	            String updateSQL = "UPDATE student SET name=?, email=?, phone=? WHERE id=?";
	            PreparedStatement updatePS = connection.prepareStatement(updateSQL);

	            updatePS.setString(1, newData.getName());
	            updatePS.setString(2, newData.getEmail());
	            updatePS.setString(3, newData.getPhone());
	            updatePS.setInt(4, id);

	            int rows = updatePS.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Student Updated Successfully!");
	            }

	        } else {
	            System.out.println("Student Not Found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
