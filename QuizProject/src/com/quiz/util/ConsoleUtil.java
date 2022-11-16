package com.quiz.util;

import java.util.Scanner;

public class ConsoleUtil {
	
	public static Scanner sc;

	public static int getMenuOption() {
		System.out.println("Welcome! What would you like to do?");
		System.out.println("1.Play quiz");
		System.out.println("2.View score");
		System.out.println("3.View score list");
		System.out.println();
		System.out.println("4.Exit");
		System.out.println("Choose one of the above options: ");
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		return i;
	}
	
	
}
