package com.ysmdemo.javanewfeature;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class CollectionsExample1 {

	public static void main(String[] args) {
		 HashSet<String> set=new HashSet<String>();
		 set.add("Apple");
		 set.add("Apple2");
		 set.add("Apple3");
		 System.out.println(set);
	Comparator<Employee> higherSalaryWise= (e,e1)-> {
		if(e.salary<e1.salary) return 1;
		if(e.salary>e1.salary) return -1;
		return 0;
	};
	
	TreeSet<Employee> employees=new TreeSet<Employee>(higherSalaryWise);
	employees.add(new Employee(1,100));
	employees.add(new Employee(2,5600));
	employees.add(new Employee(3,100000));
	employees.add(new Employee(4,10));
	System.out.println(employees);
	
	
	}
}

class Employee
{
	@Override
	public String toString()
	{
		return "id ="+id+" , salary "+salary ;
	}
	public Employee(int i, int j) {
		id=i;
		salary=j;
	}
	int id;
	int salary;
}