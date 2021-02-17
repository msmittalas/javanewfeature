package com.ysmdemo.java11newfeature;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OCJPStreamDemo {

	public static void main(String[] args) {
		Runnable r= new StreamDemo2();
		r.run();
	}
}

/*
 Stream Demo --->
 	Stream in Java is a sequence of data. A Stream pipeline consist of operations that run on stream  to produce a result.
 
 	Finite Streams Stream<Integer> stream= Stream.of(1,2,3);
 	Infinite Streams -->  No Limit  Stream<Integer> oddNumbers= Stream.iterate(1, x->x+2); 
 
 
 * */
/*
//Terminal Operation : 
count 
min 
max 
findAny
allMatch anyMatch noneMatch
forEach
reduce
collect
limit  
skip skips number of elements
flatMap combines multiple stream and remove empty object and make one stream
sorted sorts natural order
sorted (Comparator <? super T> comprator)
*/
class StreamDemo2 implements Runnable
{
		public void run(){
			Stream<Integer> s= Stream.of(1,2345,45,34,36,34,64,65,3);
			System.out.println(s.sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0));
			s= Stream.of(1,2345,45,34,36,34,64,65,3);
			System.out.println(s.reduce((x,y)->x+y).get());
			s= Stream.of(1,2345,45,34,36,34,64,65,3);
			System.out.println(s.map( t-> t.toString()).collect(Collectors.joining(",")));
			var list = List.of("Toby", "Anna", "Leroy", "Alex");
			list.stream().
			filter(x->x.length()==4)
			.sorted()
			.limit(2)
			.forEach(System.out::println);
			IntStream  iStream= IntStream.of(1,2345,45,34,36,34,64,65,3);
		 IntSummaryStatistics stats=	iStream.summaryStatistics();
		 System.out.println(stats.getAverage());
		 System.out.println(stats.getMax());
		 
		 	
		}
}
	






class StreamDemo implements Runnable
{
		public void run() 
		{
			Stream<Integer> stream= Stream.of(1,2,3);
			//System.out.println(stream.count());
			Stream<Integer> oddNumbers= Stream.iterate(1,x->x<=100,x->x+2);
			oddNumbers.forEach(System.out::print);
			stream=Stream.empty();
			stream=Stream.of(1,2,3);
			
			
		}
}
