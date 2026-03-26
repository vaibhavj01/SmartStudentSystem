package com.vaibhav.smartStudent;

import java.util.Date;
import java.util.Scanner;

import dao.*;
import model.*;
public class ConsoleUI {
	public static void start(StudentDAO studentdao, CourseDAO courseDAO, EnrollmentDAO enrollmentDAO ) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== SMART STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student ");
            System.out.println("4. Delete Student");
            System.out.println("5. Add course");
            System.out.println("6.view Courses");
            System.out.println("7.Add Enrollment");
            System.out.println("8.view Enrollment");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

             
                    
                    Student student = new Student(0, name, email, phone);
                    studentdao.insertStudent(student);
                    break;

                case 2:
                    studentdao.readStudent();
                    break;

                case 3:
                    sc.nextLine();

                    System.out.println("Search By:");
                    System.out.println("1. Student ID");
                    System.out.println("2. Name");

                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    String searchType = "";
                    String value = "";

                    if (searchChoice == 1) {
                        searchType = "id";
                        System.out.print("Enter Student ID: ");
                        value = sc.nextLine();
                    } else if (searchChoice == 2) {
                        searchType = "name";
                        System.out.print("Enter Name: ");
                        value = sc.nextLine();
                    } else {
                        System.out.println("Invalid Choice!");
                        break;
                    }

                    // New Data Input
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    Student updatedStudent = new Student(0, newName, newEmail, newPhone);

                    studentdao.updateStudentBySearch(searchType, value, updatedStudent);

                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int Sid = sc.nextInt();

                    studentdao.deleteStudent(Sid);
                    break;

                case 5:
                	sc.nextLine();
                	System.out.println("Course name: ");
                	String course_name = sc.nextLine();
                	
                	System.out.println("course duration: ");
                	int duration = sc.nextInt();
                    
                	Course courses = new Course(0, course_name, duration);
                	courseDAO.insertCourses(courses);
                	break;
                case 6:
                	courseDAO.readCourses();
                	break;
                	
                case 7:

                    sc.nextLine();

                    System.out.print("Student_Id: ");
                    int student_id = sc.nextInt();

                    System.out.print("Course_Id: ");
                    int course_id = sc.nextInt();

                    sc.nextLine(); // clear buffer

                    System.out.print("Enrollment Date (yyyy-MM-dd): ");
                    String dateInput = sc.nextLine();

                    Date enrollment_date = null;

                    try {
                        java.text.SimpleDateFormat sdf =
                                new java.text.SimpleDateFormat("yyyy-MM-dd");

                        enrollment_date = sdf.parse(dateInput);

                    } catch (Exception e) {
                        System.out.println("Invalid Date Format!");
                        break;
                    }

                    Enrollment enrollment =
                            new Enrollment(0, student_id, course_id, enrollment_date);

                    enrollmentDAO.insertEnrollment(enrollment);

                    break;
                    
                case 8:
                	enrollmentDAO.readEnrollment();
                	break;
                	
                case 10:
                	System.exit(0);
            }
        }
    }
}
