package com.ysmdemo.javanewfeature;
/*
 * static method inside Interface
 * Why ?
 * General Utility Methods can be created inside interface in the form of staticc method 
 * 
 * overriding method conccept wont work
 * 
 * 
 * */


public class StaticMethodInInterfaceExample1  implements CustomJobFinder{

	public static void main(String[] args) {
		
		//find(); wont work
		//StaticMethodInInterfaceExample1.find()  wont work
		//CustomJobFinder.find(); works
	}
	
	public void find()
	{
		
		//its not overriding , its just another method of this class
	}
}



interface CustomJobFinder
{
	public static void find()
	{
		System.out.println("find interface");
	}
}