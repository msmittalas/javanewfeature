package com.ysmdemo.javanewfeature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		
		
		String s1=""
				+ "";
		System.out.println(s1.substring(0,6));
		
		
		
		
		
		//print(Stream.of("hi"));
		HashSet<String> demo= new HashSet<String>();
		demo.add("Apple");
		demo.add("Apple2");
		demo.add("Apple3");
		demo.add("Apple4");
		Iterator<String> iterator= demo.iterator();
		while(iterator.hasNext())
		{
			String s=iterator.next();
			if(s.contains("Apple"))
			{
				iterator.remove();
			}
		}
		System.out.println(demo);
		
	}

    public static void print(Stream<String> stream) {
   Consumer<String> print = System.out::println;
  
   stream.peek(print)
         .peek(print)
         .map(s -> s)
         .peek(print)
         .forEach(print);
  
}
}