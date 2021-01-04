package com.learning.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamMain {

	public static void main(String[] args) {
		// Stream variable only can be used once, subsequence use will results in error
		// exception

		// Convert array into stream and limit loop print to 3 items
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.limit(3).forEach(System.out::print);
		System.out.println();

		// Generate integer between 2 and 5 (exclusive 5)
		intStream = IntStream.range(2, 5);
		intStream.forEach(System.out::print);
		System.out.println();

		// Generate integer starting from 0 with i+2 for 4 items
		intStream = IntStream.iterate(0, i -> i + 2).limit(4);
		intStream.forEach(System.out::print);
		System.out.println();

		// Random generate number for 2 items
		intStream = IntStream.generate(() -> {
			return (int) (Math.random() * 10000);
		});
		intStream.limit(2).forEach(System.out::println);

		// Re-access stream variable will resulted in java.lang.IllegalStateException:
		// stream has already been operated upon or closed
		try {
			intStream.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Stream error : " + e);
		}

		// Utilized machine multiple cores (with threads) to improve process
		// performance. Result might not be in sequence eg.653829471
		IntStream stream = IntStream.range(1, 10);
		stream.parallel().forEach(System.out::print);

		/**
		 * Result :
		 * 
		 * 123 
		 * 234 
		 * 0246 
		 * 944 
		 * 9112 
		 * Stream error : java.lang.IllegalStateException: stream has already been operated upon or closed 
		 * 658973421
		 */
	}

}
