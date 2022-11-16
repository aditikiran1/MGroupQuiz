package com.quiz.delegate;

import java.util.HashMap;

import com.quiz.model.Question;
import com.quiz.model.Student;
import com.quiz.service.QuestionsService;
import com.quiz.service.QuizService;
import com.quiz.service.StudentService;
import com.quiz.util.ConsoleUtil;

public class QuizDelegate {

	public static void execute() {

		Student student = null;
		switch (ConsoleUtil.getMenuOption()) {
		case 1:
			StudentService studentService = new StudentService();
			student = studentService.getStudentEntry();
			if (student != null) {
				student.setMarks(0);
				QuestionsService questionsDelegate = new QuestionsService();
				HashMap<Integer, Question> questionsMap = questionsDelegate.getQuestions();
				QuizService quizService = new QuizService();
				student = quizService.startQuiz(questionsMap, student);
				studentService.updateStudentDB(student);
				studentService.showStudentResult(student);
			} else {
				ConsoleUtil.getMenuOption();
			}
			break;
		case 2:
			StudentService studentService2 = new StudentService();
			student = studentService2.getStudentEntry();
			if (student != null) {
				studentService2.showStudentResult(student);
			} else {
				ConsoleUtil.getMenuOption();
			}
			break;
		case 3:
			StudentService studentService3 = new StudentService();
			studentService3.getStudentScoreList();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.exit(0);
			break;
		}
		
		

	}

}
