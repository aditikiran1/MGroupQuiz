package com.quiz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.quiz.model.Question;
import com.quiz.util.ConnectionUtility;

public class QuestionsService {
	public HashMap<Integer, Question> getQuestions() {
		HashMap<Integer, Question> map = new HashMap<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = ConnectionUtility.getConnection();
		String query = "select * from question";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Question question = new Question();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setQuestion_text(rs.getString("question_text"));
				question.setQoption1(rs.getString("qoption1"));
				question.setQoption2(rs.getString("qoption2"));
				question.setQoption3(rs.getString("qoption3"));
				question.setQoption4(rs.getString("qoption4"));
				question.setAnswer(rs.getString("answer"));

				map.put(rs.getInt("question_id"), question);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return map;

	}
}