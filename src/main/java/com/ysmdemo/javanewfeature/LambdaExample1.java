package com.ysmdemo.javanewfeature;

import java.util.function.Function;

public class LambdaExample1 {

	public static void main(String[] args) {
		
	print(10);
	}
	
	public static void print(Integer val)
	{
		test((t)-> "Blue color :"+t);
		  
		test((t)->{ return "GREEN color :"+t;});
		
		test(new MyCustomFunction());
		
		test(t -> "my simple lamba"+t);
	}
	
	public static void test(Function<Integer, String> functon)
	{
		System.out.println(functon.apply(10));
	}
	
	
}
class MyCustomFunction implements Function<Integer, String>
{

	@Override
	public String apply(Integer t) {
		// TODO Auto-generated method stub
		return "MyCustom Color :"+t;
	}
}




