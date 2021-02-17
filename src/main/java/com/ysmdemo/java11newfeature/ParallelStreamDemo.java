package com.ysmdemo.java11newfeature;

import java.util.List;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		Runnable r= new ParallelDemo();
		r.run();
	}
}

/*
  Parallel Streams : one of the most powerful features of the Streams API is built in concureency support 
  
  A parallel stream is a stream that is capable of processing results concurrently,
   using multiple threads. For example, you can use a parallel stream and the map() operation 
   to operate concurrently on the elements in the stream,
   vastly improving performance over processing a single element at a time.
 * .
 * The number of threads available in a parallel stream is proportional to the number of available CPUs in your environment.
 * 
 * The Stream API includes an alternate version of the forEach() operation called forEachOrdered(), which forces a parallel stream to process the results in order at the cost of performance. 
 * For example, take a look at the following code snippet:
 * */
class ParallelDemo implements Runnable
{
	public void run()
	{
		System.out.println("Enter");
		List.of(1,2,3,4).parallelStream().map(this::dowork).forEach(System.out::println);
		
	}
	public int dowork(int a)
	{
		try{Thread.sleep(2000);}catch(Exception e) {e.printStackTrace();}
			return a*10;
	}
}