package com.ysmdemo.javanewfeature;
/*
 * Predefined Functional Interfaces
 * 
 * 1. Predicate ----> some sort of testing  
 * 2. Function --->
 * 3. Consumer ---->
 * 4. Supplier --->
 * 
 * Predicate : 
 *   Peform some condition and return true /false
 * Predicate Joining
 * 
 * */

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateInterfaceExample1 {

	
	
	public static void main(String[] args) {
		
		Predicate<Integer> cond= I-> I>10;
		System.out.println(cond.test(100));
		Predicate<String> lengthCond=S -> S.length()>4;
		System.out.println(lengthCond.test("APPLE"));
		
		ArrayList<String> data= new ArrayList<String>();
		data.add("Apple");
		data.stream().filter(lengthCond);
		
		//Predicate Joining Example 
		
		Predicate<Integer> cond2= I-> I%2==0;
		System.out.println(cond.and(cond2).test(80));
		Predicate<Integer> PRED=Predicate.isEqual(10);
		System.out.println(PRED.test(10));
		
	}
	
	
	
}




