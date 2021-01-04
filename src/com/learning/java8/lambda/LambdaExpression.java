package com.learning.java8.lambda;

public class LambdaExpression {

	public static void main(String[] args) {
		PlayerService playerService = (player, num) -> System.out.println(player + " wears jersey number " + num);
		playerService.sayMessage("Henry", 14);

		StringManipulation substring = (String string, int start, int end) -> string.substring(start, end);
		StringManipulation indexOf = (String string, int start, int end) -> string.charAt(start) + " & "
				+ string.charAt(end);

		System.out.println("Substring " + substring.operation("Apple Pie", 0, 3));
		System.out.println("Index Of " + indexOf.operation("Apple Pie", 0, 3));

		/**
		 * Result :
		 * 
		 * Henry wears jersey number 14 
		 * Substring App 
		 * Index Of A & l
		 */
	}

	interface PlayerService {
		void sayMessage(String player, int num);
	}

	interface StringManipulation {
		String operation(String string, int start, int end);
	}

	private String operate(String string, int start, int end, StringManipulation stringManipulation) {
		return stringManipulation.operation(string, start, end);
	}
}
