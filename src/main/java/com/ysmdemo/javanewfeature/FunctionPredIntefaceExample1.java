package com.ysmdemo.javanewfeature;

import java.util.function.Function;

/*
 * 
 * Function is a math's word like Predicate 
 * Predicate perfom condition check and always return boolean value
 * Function return any type.
 *	 apply method present in Function interface
 * 
 * Function chaining 
 * 
 * f1.andThen(f2) ---> first f1 will be applied and then f2 
 * f1.compose(f2) ---> first f2 will be applied and then f1
 * 
 * */



public class FunctionPredIntefaceExample1 {

	public static void main(String[] args) {
		Function<String, String> lowerFunc= (t)-> t.toLowerCase();
		Function<String, String> UpFunc= (t)-> t.toUpperCase();
		
		System.out.println(lowerFunc.andThen(UpFunc).apply("MitTal"));
		System.out.println(lowerFunc.compose(UpFunc).apply("MitTal"));
		
		
	}
}
