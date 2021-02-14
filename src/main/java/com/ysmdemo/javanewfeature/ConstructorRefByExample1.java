package com.ysmdemo.javanewfeature;

import java.awt.image.SampleModel;

public class ConstructorRefByExample1 {

	public static void main(String[] args) {
		//Simple lambda Expression
		InterEmpl impl= ()->{return new EmployeesC();};
		//COnstructor Ref
		InterEmpl implCons= EmployeesC :: new ;
		EmployeesC e= implCons.get();
	}
}
class EmployeesC
{
	
	public EmployeesC()
	{
		System.out.println("Emplotees Cons");
	}
	
}

interface InterEmpl
{
	public EmployeesC get();
}