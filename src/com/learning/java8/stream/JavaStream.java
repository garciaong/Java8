package com.learning.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class JavaStream {

	public static void main(String [] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		
		//Filter function
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.forEach(filterStr -> System.out.println(filterStr));
		
		//Count function
		int count = (int)strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Total empty string in array : "+count);
		
		//Calculate square, return as list
		List<Integer> squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(square -> System.out.println(square));
		
		//Statistic generator
		IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
	    System.out.println("Lowest number in List : " + stats.getMin());
	    System.out.println("Sum of all numbers : " + stats.getSum());
	    System.out.println("Average of all numbers : " + stats.getAverage());
	    
	    //Generate 10 random numbers
	    Random random = new Random();
	    random.ints().limit(10).sorted().forEach(System.out::println);
	    
	    numbers.forEach(num -> activateNumber(num));
	    
	    List<Integer> filteredNums = numbers.stream().filter(num -> num>=5).collect(Collectors.toList());
	    filteredNums.forEach(filteredNum -> System.out.println(filteredNum+" equals or larger than 5"));
	}
	
	private static void activateNumber(int num) {
		System.out.println("Number "+num+" activated");
	}
	
}
