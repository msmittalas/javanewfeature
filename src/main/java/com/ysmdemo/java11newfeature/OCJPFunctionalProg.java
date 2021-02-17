package com.ysmdemo.java11newfeature;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

// Functional Interface : 

/*
 
 Supplier<T>	T	get()	0
Consumer<T>	void	accept(T)	1 (T)
BiConsumer<T, U>	void	accept(T,U)	2 (T, U)
Predicate<T>	boolean	test(T)	1 (T)
BiPredicate<T, U>	boolean	test(T,U)	2 (T, U)
Function<T, R>	R	apply(T)	1 (T)
BiFunction<T, U, R>	R	apply(T,U)	2 (T, U)
UnaryOperator<T>	T	apply(T)	1 (T)
BinaryOperator<T>	T	apply(T,T)	2 (T, T)
 * 
 * */
public class OCJPFunctionalProg {

	public static void main(String[] args) {
		Runnable r = new OptionalDemo();
		r.run();
		}
}
//Returning an Optional

/*
 
   How do we express this we dont knoiw or not applicable answer in Java ?
   We use the Optional type.
   An Optional is created using a factory.
   You can either request an empty Optional or pass a value for the optional to wrap
 * */

class OptionalDemo  implements Runnable
{
		public void run()
		{
			Optional<Integer> id= Optional.of(10);
			//System.out.println(i.isPresent());
			Function<Integer, Optional<Integer>> data= (x) -> Optional.ofNullable(x);
			System.out.println(data.apply(null).isPresent());
			Integer i=null;
			Optional<Integer> o= (i==null) ? Optional.empty():Optional.of(i) ;
			//same can  be written in
			Optional<Integer> da=Optional.ofNullable(10);
		}
		
}



//Functional Chaining 

class ChainDemo implements Runnable
{
	 public void run()
	 {
		 Predicate<Integer> isEven= x -> x%2==0;
		 Predicate<Integer> isOdd= isEven.negate();
		 Predicate<Integer> isNumber5= x->{System.out.println("isNumber5"); return x==5;};
		 Predicate<Integer> isNumber3= x->{System.out.println("isNumber3"); return x==3;};
		 
		 Predicate<Integer> isNumber2= x-> x==2;
		 Predicate<Integer> isNumberEndsWith5=  x-> Integer.toString(x).endsWith("5");
	
		 Predicate<Integer> isDivBy3= x-> {
			 String d=Integer.toString(x);
			 long total=d.chars().asLongStream().sum();
			 return total%3==0;
		 };
		 Predicate<Integer> checkActualPrime= x-> 
		 { for(int i=2;i<=x/2;i++)
		 {
			 System.out.print(i);
			 if(x%i==0)
			 {
				 System.out.println("divisble by "+i);
				 return false;
			 }
		 }
		 return true;
	 }
		 ;
		Predicate<Integer> isPrime= isNumber2
									.or(isNumber5)
									.or(isNumber3)
									.or(isOdd
											.and(isDivBy3.negate())
											.and(isNumberEndsWith5.negate())
											.and(checkActualPrime)
									);
		
		System.out.println(isPrime.test(5));
									
		 
		 
	 }

}


//UnaryOperator and BinaryOperator 

class UnaryBinDemo implements Runnable
{
	public void run()
	{
		UnaryOperator<Integer> increment=x -> ++x;
		System.out.println(increment.apply(10));
		BinaryOperator<Integer> add=(x,y)-> x+y;
		System.out.println(add.apply(10, 20));
		
	}
}





//Custom Tri Function

interface TriFunction<T,S,U,R>
{
	public R apply(T t,S s, U u);
}
class CustomTriFunction implements Runnable
{
	public void run()
	{
		 TriFunction<Integer,Integer,Integer,Integer> findMaxOutOfThree= (t,s,u)-> Math.max(Math.max(t,s),u);
		 System.out.println(findMaxOutOfThree.apply(10,10,10));
	}
}


//FunctionAndBiFuciton

class FunAndBiFuncDemo implements Runnable
{
	public void run()
	{
		Function<Integer, Double> mltoLtr= (v)-> v/1000D;
		System.out.println(mltoLtr.apply(1));
		BiFunction<Integer, Integer, Integer> MAX= Math::max;
		System.out.println(MAX.apply(10,20));
		List<Integer> lst1= new ArrayList<Integer>(List.of(2,4,5));
		List<Integer> lst2= new ArrayList<Integer>(List.of(1,3,4,5));
	
		BiConsumer<List<Integer>, List<Integer>> getCommon = (t,s)-> t.retainAll(s);
		getCommon.accept(lst1, lst2);
		System.out.println(lst1);
		lst1= new ArrayList<Integer>(List.of(2,4,5));
		lst2= new ArrayList<Integer>(List.of(1,3,4,5));
		List<Integer> common=lst1.stream().filter(lst2::contains).collect(Collectors.toList());
		System.out.println(common);
		
	}
}



//Predicate BiPredicate 

class PredicateBiPredDemo implements Runnable
{
	public void run()
	{
		Predicate<Integer> isEven= (t)->t%2==0;
		System.out.println(isEven.test(17));
		System.out.println(isEven.negate().test(17));
		BiPredicate<String,String> searchWord= String::contains;
		System.out.println(searchWord.test("My Life My Rule", "Rule"));
		
	}
}






//  Consumer and BiConsumer 
//   it has one method accept   either 1 or 2 parameter respe.
class ConsumerAndBiConDemo implements Runnable
{
		public void run()
		{
			Consumer<String> print=System.out::println;
			print.accept("hello");
			BiConsumer<String, Integer>  cons= (S1,I) -> System.out.println(S1+I);
			cons.accept("Apple", 10);
		
			
		}
		
}

//Suplier 
//=-===Supplier<T>


class SupplierDemo implements Runnable
{

	public void run()
	{
		Supplier<LocalDate> s1=LocalDate::now;
		Supplier<LocalDate> s2= ()-> LocalDate.now();
		LocalDate d1=s1.get();
		LocalDate d2=s1.get();
		Supplier<ArrayList<Integer>> sup= ArrayList<Integer>::new;
	}

}