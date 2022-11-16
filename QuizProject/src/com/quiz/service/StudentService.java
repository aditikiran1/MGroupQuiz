package com.quiz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import java.util.Scanner;

import com.quiz.model.Student;
import com.quiz.util.ConnectionUtility;

public class StudentService {

	public Student getStudentEntry() {
		Student student = null;
		System.out.println("enter your id: ");
		Scanner sc = new Scanner(System.in);
		int stud_id = sc.nextInt();
		Connection con = ConnectionUtility.getConnection();
		String query = "select * from student where stud_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stud_id);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				System.out.println("Hello, " + rs.getString("stud_name"));

				student = new Student();
				student.setStud_id(rs.getInt("stud_id"));
				student.setStud_name(rs.getString("stud_name"));
				student.setMarks(rs.getInt("marks"));
			}
			if (student == null) {

				System.out.println("Invalid Id.");
						
				return student;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return student;
	}

	public void updateStudentDB(Student student) {

		Connection con = ConnectionUtility.getConnection();
		String query = "update student set marks=? where stud_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, student.getMarks());
			pstmt.setInt(2, student.getStud_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void showStudentResult(Student student) {
		System.out.println("Marks obtained are: " + student.getMarks());
		System.out.println("Class obtained is: " + getStudentMarksClass(student));

	}

	public String getStudentMarksClass(Student student) {
		String marksClass = null;
		int marks = student.getMarks();
		if (marks >= 8 && marks <= 10) {
			marksClass = "A";
		} else if (marks == 6 || marks == 7) {
			marksClass = "B";
		} else if (marks == 5) {
			marksClass = "C";
		} else {
			marksClass = "D";
		}
		return marksClass;
	}

	

	public void getStudentScoreList() {
		System.out.println("List of Student Marks: ");

		LinkedList<Student> list = new LinkedList<>();

		Connection con = ConnectionUtility.getConnection();
		String query = "select * from student order by marks desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setStud_id(rs.getInt("stud_id"));
				student.setStud_name(rs.getString("stud_name"));
				student.setMarks(rs.getInt("marks"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Id\t" + "Name\t" + "Marks");
		for (Student student : list) {
			System.out.println(student.getStud_id() + "\t" + student.getStud_name() + "\t" + student.getMarks());
		}

	}
}
