package com.quiz.model;

public class Student {
	private int stud_id;
	private String stud_name;
	private int marks;

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", stud_name=" + stud_name + ", marks=" + marks + "]";
	}

	public Student(int stud_id, String stud_name, int marks) {
		super();
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.marks = marks;
	}

	public Student() {
		super();
	}

}
