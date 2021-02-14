package com.ysmdemo.java11newfeature;


import java.util.function.Predicate;

import com.ysmdemo.java11newfeature.Sample.SampleInner1.SampleInner2;

public class OCPJavaSEPractice1 {

	
	public static void main(String[] args) {

		
		
		
	}
}

/* Final ---to local Variable
 *		local variable has to be initalzed before use can be deffer until first access 
 *		final variable cannot be reasign
 *   	object variable marked as Final doesnt mean you cant change the content
 * Final ---to Instance Variable /static class variable
 *		You cannot change the value but you can deffer the assigntment till Constructions  either in Instance Initializer or COntrustur
 *		  
 * Final --- to Methods 
 * 		YOu can not override that method. 	
 *   
 * Final -- -to Class
 * 		If you mark class as Final then you can inherit that method 	
 * 			  
 * */
final class Demo{
	
}
//Not Possible -->//class Demo2 extends Demo{}
// camon mark class abstract and final 
class FinalClassInfo
{
		final int age;
		final int salary=10;
		final int departmentId;
		//Instance Initalizer
		{
			departmentId=10;
		}
		final static int SOME_CONSTANT;
		final static int SOME_CONSTANT_2=10;
		
		static
		{
			SOME_CONSTANT=10;
		}
		
		FinalClassInfo()
		{
			age=10;
			//salary=10;
		}
		 public static void test() {}
		
	public void final_local_variables()
		{
				final int i;
				i=10; 
				System.out.println(i);
				//i=10;
				final StringBuffer buffer= new StringBuffer("Apple");
				buffer.append("App");
				// buffer= new StringBuffer("New"); Compiler error
		}
}
class FinalClassInfoChild extends FinalClassInfo
{
		public static void test(int a){}
	
		//You cannot override but can overload
		/*@Override
		public  void test() {}
		*/
}
/*
 * 
===========================================
Inner Classes / Nested Classes 

	 Types of Inner / Nested 
	 
	 Inner Class :  A non - static type defined at the member level of class 
	 Static Inner CLass  : a static type define at member level of class 
	 Local Class : A Class defined within method body
	 Annonymouys class :  A Special case of a local class that doesnt have a name
	 
	 They encapsulate helper classes by restrcition them to containing class 
	 It makes class more readable 
	 
	 


*/

//Inner class
/*  inner class can be marked as public protected default or private 
 *  inner class can extend all types of classes and can implemented Interfaces 
 *  inner class cannot have static variable as inner class is instance member of outer class 
 *  inner class can access outter class members invcluding priuvate members with help of sepcial this 
 *   
 * */
 class Sample 
{		
	int x;
		public class SampleInner1{
			int x;
			class SampleInner2 
			{
				int x;
				{
					x=this.x;
					x=SampleInner1.this.x;
					x=Sample.this.x;
				}
			}
		}
		
		public static void main(String[] args) {
			
			Sample s= new Sample();
			s.x=20;
			SampleInner1 s1=  s.new SampleInner1();//
			s1.x=10;
			SampleInner2 s2= s1.new SampleInner2();
			System.out.println(s2.x);
			Sample.SampleInner1.SampleInner2 s2d=s1.new SampleInner2();
			
		}
}
 
 /*
  * .class Files for inner classes 
  * Compiling the Sample,.java class with which we have been workiung creates two class  files. Outer.class you should be expecting . 
  * for the inner class the compiler creates Sample$SampleInner1.class  and Sample$SampleInner1$SampleInner2.class 
  * 
  * 
  * */
	

/*
 *  static nested Classes 
 *  It act like Static members of Outer class
 *  We can create an object of static nested class without Outer class object
 *  The outer class can refer  to fields and method of static nested class
 *  static class can be imported just another java class
 * */
 
 class SampleStaticClass
 {
	  
	  	static class Samplestatic1
	 	{
	  			private int price=6;
	 	}
	  	
	  	public static void outer_method()
	  	{
	  			System.out.println(new Samplestatic1().price);
	  	}
 }
/*
 * Local Classes
 * 
 *  A local Class is a nested class defined within a method . Like local  variables , a local class declaration does not exist 
 *  until the method is invoked and it goes out of scope when the method returns. just like local variable 
 *  --cannont marked as static or can declare static method or field but can create final static constants 
 *  They have access to all fields and methods of the enclosing class (when defined in an instance method).
 * Let's talk about that now. The compiler is generating a .class file from your local class. 
 *		 A separate class has no way to refer to local variables. 
 *		If the local variable is final, Java can handle it by passing it to the constructor of 
 * 		the local class or by storing it in the .class file. If it weren't effectively final,
 *  	these tricks wouldn't work because the value could change after the copy was made.
 * 
 * 
 * */	  	
	  	class SampleLocalClass
	  	{
	  		public void test()
	  		{
	  			int x=10;
	  			x=10;
	  			 class LocalDemo
	  			 {
	  				 public void print()
	  				 {
	  					 //compiler error as local class cannt access instant variable it has to be final
	  					 //System.out.println(x);
	  				 }
	  			 }
	  		}
	  	}
	  	
	  	
/**
 * 
 * Anonymous CLass : 
 *  Its special local class that doest have a nbame. its declared and created all in one statement using the new keyword
 *  Prior to Java 8, such classes were frequently used for async tasks and handlers. for exmaple , 
 *  	the following shows an anonymous class used as an event handler in JavaFx
 * 
 * 
 * 
 * 
 */

//==================================================================================
/*
 * Interface 
 *		before Java 8 and 9 , There were only two types of members can be added in interface . constant (finaL) and abstract method
 *		Since Java 8/9 four new method types can be added 
 *		default method : method marked default inside interface
 *		to provide default implementations  and backward compatibility. 
 *		with default method, you can add method to existing interface without disturbing the contracts
 *		if class implements two interfaces which has sample default methods then class has to override any one method 
 *		A default method may be declared only within an interface.
A default method must be marked with the default keyword and include a method body.
A default method is assumed to be public.
A default method cannot be marked abstract, final, or static.
A default method may be overridden by a class that implements the interface.
If a class inherits two or more default methods with the same method signature, then the class must override the method.
A static method cannot be marked abstract or final.
A static method is not inherited and cannot be accessed in a class implementing the interface 
 	without a reference to the interface name
 
 
 By introducing six different interface member types, 
 Java has certainly blurred the lines between an abstract class and an interface. 
 A key distinction, though, is that interfaces 
 do not implement constructors and are not part of the class hierarchy.
  While a class can implement multiple interfaces, it can only directly extend a single class.
 
 
 * 
 * 
 * 	
 * */

	  interface SampleInterfaceDemop1
	  	{
	  		 int CONSTANT=10;
	  		// public void method();//abstract
	  		 public default void method_demo(int a) {}
	  		 public static void method_static() {}
	  		 //to reduce duplication codes in default method
	  		 private  void method_1() {} // Java 9
	  		 // to reduce duplication  codes in static method
	  		private static void method_static_private() {}
	  	}
	  	interface SampleInterface2
	  	{
	  			public default void method_demo(int a) {}
	  	}
	  	
	  	



//=====================================================================

/*
 * 
Functional Programming  
	Functional Interfaces : are used as the basis of lamda Expressions in functional Programming
	Functional interface : contains single method 
	Your friend SAM can help you to remember this : SAM ---> Single Abstract Method
	adding the annotation to a functional interface is optional.



 * 
 * 
 * */

@FunctionalInterface
interface Sprint
{
	public void spring(int speed);
}
interface Sprint1 extends Sprint{}
interface Sprint2  extends Sprint,Sprint1
{
	@Override
	public default void spring(int speed) {}
}
class FunctionalObjectSample
{
	public void doTest(int speed) {}
}
class DemoFunc{
	
	public static void main(String[] args) {
		Sprint s= (x) -> {System.out.println(x);};
		s.spring(100);
		s= System.out::print;
		s.spring(10);
		s= new FunctionalObjectSample()::doTest; // Functional INterface with Object
	}

}
@FunctionalInterface
 interface Climb {
	   void reach();
	   default void fall() {}
	   static int getBackUp() { return 100; }
	   private static boolean checkHeight() { return true; }
	}

interface ObjectInterface{
	//Since Java assumes all classes extend from Object, you also cannot declare an interface method that is incompatible with Object. 
	//public int toString();
}
/*
 * Compiler Error this doest count as SAM Single abstract method rule 
@FunctionalInterface
interface ObjectInterface2{
	//Since Java assumes all classes extend from Object, you also cannot declare an interface method that is incompatible with Object. 
	//public String toString();
}

*/
//=======================================
/*
 
 Implementing Functional Interfaces with Lambdas :
 Lambda expressions rely on the notion of deferred execution. Deferred execution means that code is specified now but runs later. In this case, later is when the print() method calls it. 
 Even though the execution is deferred, the compiler will still validate that the code syntax is correct.
  Parenthese can be omitted only if there is a single param and its type is not explicitly stated.
 Lambda bodies are allowed to use static variables, instance variables, and local variables if they are final or effectively final. Sound familiar? Lambdas follow the same rules for access as local and anonymous classes! 
 This is not a coincidence, as behind the scenes, anonymous classes are used for lambda expressions
 **/
class LambdaTest
{
	public static void main(String[] args) {
		Predicate<String> isEmpty= (s) -> s.isEmpty();
		isEmpty= (String s) ->{ return  s.isEmpty(); };
		isEmpty=(String s) ->  s.isEmpty();
		isEmpty= s->s.isEmpty();
		isEmpty=String::isEmpty;
		System.out.println(isEmpty.test("Apple"));
	}
}

//---------------------------VAR KEYWORD  Java 10
/*
 *  var keyword was introduced in java 10  and it detectes automatically the datatype of a variable based on surrounding context
 *  var can be used in a local variable declaration.
 *  var cannot be used in an instance and global variable declaration.
 *   var cannot be used as a Generic type.
 * */

class VAREXAMPLE
{
	
	public int cal(int x,int  y )
	{
		var z = x+y;
		Predicate<String> t=(var s)-> s.isEmpty();
return z;
	}
	
}









