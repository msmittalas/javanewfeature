package com.ysmdemo.javanewfeature;

/*
 * 
 * Interface vs Abstract Class
 *  interface will not have constructor
 *  final varialble in interface but not in Abstract by default
 *  You cant create instace and static blocks but Abstract you can 
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */





public class DefaultMethodExample1 {

	
	public static void main(String[] args) {
		MySort m=new MySort();
		m.sortDefault();
	}
	
}
class MySort implements CustomSort,CustomSort2
{
	 public void sortDefault() 
	{
		CustomSort2.super.sortDefault();
	}
}

interface CustomSort
{
		default public void sortDefault() 
		{
			System.out.print("Hello World");
		}
}
interface CustomSort2
{
		default public void sortDefault() 
		{
			System.out.print("Hello World");
		}
}
