package com.ysmdemo.javanewfeature;
/*
 * any collection object contains stream method which can gives an object of Stream
 * Collection interface contains stream method which is default method
 * 
 * Stream is in inteface present in java.util.stream.
 * 
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[] args) {
		Stream<String> streamOfStrng=getListOfString().stream();
		streamOfStrng=streamOfStrng.filter(s->s.length()>2);
		streamOfStrng=streamOfStrng.map(s->s.toLowerCase()).sorted();
		
		List<String> list=streamOfStrng.collect(Collectors.toList());
		System.out.println(list);
		Stream<Integer> streamOfInt=getListOfInteger().stream();
		System.out.println(streamOfInt.min((i1,i2)->i1.compareTo(i2)));
		//Stream of method
		Stream<Integer> streamOfGrp= Stream.of(1,2,34,56,3646,345,35,5,6,5,5,667,4,36,346675,2);
		streamOfGrp.forEach(System.out::print);
	}
	
	static List<Integer> getListOfInteger()
	{
		List<Integer> lst=new ArrayList<Integer>();
		lst.add(10);
		lst.add(21);
		lst.add(12);
		lst.add(11);
		return lst;
	}
	
	static List<String> getListOfString()
	{
		List<String> lst=new LinkedList<String>();
		lst.add("Apple");
		lst.add("Dp0000");
		lst.add("Cpple");
		lst.add("Dpple");
		lst.add("Ep");
		
		return lst;
	}
}
