package com.ysmdemo.javanewfeature;

import java.util.ArrayList;
import java.util.function.IntPredicate;

/* Method Ref : 
 * 	code usablities 
 *  both methods should have same argument type 
 *  both methods should have same return type
 *  lambda expression alternative is Method Ref
 * 	FI can refer LE and MR    ( Functional Interface  , Lambda Expression , Method Ref)
 *  FI can refer to static or no static method
 * */

public class MethodRefByDoubleColonExample1 {

	public static void main(String[] args) {
		
		TestMyNeg tst=new TestMyNeg();
		IntPredicate predicate2= tst::test;
		tst.setA(10);
		predicate2.test(10);
		tst.setA(20);
		predicate2.test(10);
		
	}
}

class TestMyNeg
{
	int a;
		public static boolean test2(int a) 
		{
			return a<0;
		}
		public  boolean test(int c) 
		{
			System.out.println(this.a);
			return c<0;
		}
		public void setA(int a)
		{
			this.a=a;
		}
		public int getA() {return a;};
}