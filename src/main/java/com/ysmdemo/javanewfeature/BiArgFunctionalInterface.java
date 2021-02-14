package com.ysmdemo.javanewfeature;

import java.util.function.BiPredicate;

/*
 * Functional Interface which takes two arguments so thats why "BI"
 * BiPredicate 
 * BiConsumer
 * BiFunction
 * 
 * 
 * */


public class BiArgFunctionalInterface {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bothEven= (i,j) -> i%2==0 && j%2==0;
		System.out.println(bothEven.test(10, 8));
		
	}
}
