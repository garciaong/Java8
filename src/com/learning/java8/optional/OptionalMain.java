package com.learning.java8.optional;

import java.util.Optional;

public class OptionalMain {

	public static void main(String[] args) {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("no name");
		System.out.println(name);

		name = Optional.ofNullable(nullName).orElseGet(() -> "no name");
		System.out.println(name);

		Optional<String> opt = Optional.of("test");
		if (opt.isPresent()) {
			name = opt.get();
		} else {
			System.out.println("String not present");
		}
		System.out.println(name);

		name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

		/**
		 * Result :
		 * 
		 * no name 
		 * no name 
		 * test 
		 * Exception in thread "main" java.lang.IllegalArgumentException
		 */
	}

}
