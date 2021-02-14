package com.ysmdemo.javanewfeature;

import java.util.function.IntPredicate;
import java.util.function.Predicate;


/*
 *  Why we need primitive Type functional interface?
 *  by default Predicate takes Object or Wrapper class 
 *  Autoboxing comes in picture
 *  
 *  THis will slow down the process
 * 
 * 
 * 
 * */


public class PrimitiveTypeFunctionalInterExample1 {

	
	public static void main(String[] args) {
		Predicate<Integer> isNeg=t->t<0;
		int [] a= {10,-20,10,20,-50};
		//Auto boxing and Auto Unboxing 
		for(int ele : a)
		{
			System.out.println(isNeg.test(ele));
		}
		//Soln: Primitive Type Functional INterface
		
		IntPredicate  isNeg2= t->t<0;
		for(int ele : a)
		{
			System.out.println(isNeg2.test(ele));
		}
		
		
	}
	
	
}

