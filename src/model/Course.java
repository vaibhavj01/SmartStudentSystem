package model;

import java.util.Date;

public class Course {

	private int id;
	private String course_name;
	private int duration;
	public Course(int id, String course_name, int duration) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
	
}
