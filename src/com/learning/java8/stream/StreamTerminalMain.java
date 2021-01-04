package com.learning.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTerminalMain {
	public static void main(String[] args) {
		// Collect Terminal Operation
		List<String> id = Arrays.asList("Classes", "Methods", "Members");
		List<String> output = id.stream().filter(s -> s.startsWith("M")).collect(Collectors.toList());

		// For Each Terminal Operation
		output.stream().forEach(System.out::println);

		// Reduce Terminal Operation => reduce(Identity, Accumulator, Combiner)
		// Without Combiner
		List<Integer> list1 = Arrays.asList(11, 33, 44, 21);
		int finalResult = list1.stream().filter(x -> (x % 2 == 0)).reduce(0, (result, i) -> result + i);
		System.out.println("Reduce 1st Result = " + finalResult);

		// With Combiner
		List<Sum> sumList = Arrays.asList(new Sum(1), new Sum(2), new Sum(3));
		finalResult = sumList.stream().reduce(0, (accumulateResult, sum) -> accumulateResult + sum.getValue(),
				Integer::sum);
		System.out.println("Reduce 2nd Result = " + finalResult);

		/**
		 * Results :
		 * 
		 * Methods 
		 * Members 
		 * 
		 * Reduce 1st Result = 44 
		 * 
		 * Reduce 2nd Result = 6
		 * 
		 */
	}
}

class Sum {

	public Sum(int value) {
		super();
		this.value = value;
	}

	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
