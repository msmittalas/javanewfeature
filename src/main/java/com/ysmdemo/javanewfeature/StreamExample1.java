package com.ysmdemo.javanewfeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 
 * If you wnt to processs object present inside collections then we should use 1.8 Stream
 * 
 * 
 * 
 * 
 * 
 * */


public class StreamExample1 {
 public static void main(String[] args) {
	List<Integer> lst=new ArrayList<Integer>();
	lst.add(1);
	lst.add(3);
	lst.add(2);
	lst.add(3);
	lst.add(1);
	
//	lst=lst.stream().filter(i->i%2==0).collect(Collectors.toList());
	lst=lst.stream().map(t->t*10).collect(Collectors.toList());
	
	 System.out.println(lst);
	 
	 
}
}
