package com.ysmdemo.javanewfeature;

import java.util.function.Predicate;

public class LambdaExample3 {

	public static void main(String[] args) {
		
	Predicate<String> test= (t) -> { return t.length()>10 ? true : false; }; 
	Predicate<String> test2= (t) -> { return t.length()>10 ? true : false; }; 

	System.out.println(test.test("Simpleeeeeeeeeeee"));
	System.out.println(test2.test("Simpleeeeeeeeeeee"));
	
	
	
		
	}
	 public void testAn()
	 {
		 Predicate<String> test= (t) -> { return t.length()>10 ? true : false; }; 
			
	 }
	
	
}
interface Test
{
	String run();
}

/*
 *  Annonymous Inner Class      vs Lambda Expression
 * 
 * 
 * */
