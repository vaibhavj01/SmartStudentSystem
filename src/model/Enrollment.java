package model;

import java.util.Date;

public class Enrollment {

	private int id;
	private int student_id;
	private int course_id;
	private Date enrollment_date;
	
	public Enrollment(int id, int student_id, int course_id, Date enrollment_date) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.enrollment_date = enrollment_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public Date getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	
	
}
