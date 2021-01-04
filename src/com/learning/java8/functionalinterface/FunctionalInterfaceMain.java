package com.learning.java8.functionalinterface;

public class FunctionalInterfaceMain {

	public static void main(String[] args) {
		MyFunc obj = new MyFunc() {
			public void exec() {
				System.out.println("This is anonymous function");
			}
		};
		obj.exec();

		MyFunc obj2 = () -> System.out.println("This is from functional interface");
		obj2.exec();

		/**
		 * Result :
		 * 
		 * This is anonymous function 
		 * This is from functional interface
		 */
	}

}

//Annotation to check only single abstract method defined
@FunctionalInterface
interface MyFunc {
	void exec();
}