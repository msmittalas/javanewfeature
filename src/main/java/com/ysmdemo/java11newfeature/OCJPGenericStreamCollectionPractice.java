package com.ysmdemo.java11newfeature;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ysmdemo.javanewfeature.DateAndTimeExample;

 class OCJPGenericStreamCollectionPractice {

}


interface Supp<T>
{
	
	public T get();
}
class Demo1
{
	public static void main(String[] args) {
		Supp<String> s= ()-> "Helllo";
		Supp<Exception> ex= () -> new Exception("Java");
		Supp<LocalDate> date = () -> LocalDate.now();
	}
}


//-------------------Method Ref
/*
Method Ref : are another way to make the code easier to read , such as simply mentioning the name of the method
Method ref  has to be same argument and return type (my words )
The :: operator tells Java to call the println() method later. It will take a little while to get used to the syntax. 
Once you do, you may find your code is shorter and less distracting without writing as many lambdas.
 
 There are four formats for method references:

Static methods  Class::method
Instance methods on a particular instance  obj::method
Instance methods on a parameter to be determined at runtime
Constructors  CLass::new
 
 * 
 * */

@FunctionalInterface
 interface LearnToSpeak {
   void speak(String sound);
}


class DuckHelper
{
		public static void teacher(String name,LearnToSpeak trainer) {
			
			trainer.speak(name);
		}
}

class Duckling 
{
		public static void main(String[] args) {
			LearnToSpeak learner= (s)->System.out.println(s);
			learner=System.out::println;
			DuckHelper.teacher("Hell", learner);
			
		}
}

/*
 
 Reffering static method 
 
 
 * 
 * */

class Demo2
{
	public static void main(String[] args) {
		
		Consumer<List<Integer>> methodRef= Collections::sort;
		methodRef= x -> Collections.sort(x);
		methodRef.andThen(null).accept(null);
		
		
		methodRef=new Consumer<List<Integer>>() {
			
			@Override
			public void accept(List<Integer> t) {
				Collections.sort(t);
			}
		};
	}

/*
 
  Calling Instance methods on a particular object
 
 
 
 * 
 * */

	public void demoOfInstance()
	{
		
		Predicate<String> methodRef = String::isEmpty;
		
		
	}
	
	/*
	 * calling on constructor
	 * 
	 * */
	public void demoConstructor()
	{
			String s="";
			Supplier<String> t= String::new;
	}
	
	
	
	
} 

class WrapperExample
{
	 public static int solution(int[] ranks) {
		 int counter=0;
		// Arrays.sort(ranks);
		 TreeSet<Integer> set=new TreeSet<>();
		 Arrays.stream(ranks).forEach(set::add);
		 for(Integer i : set)
		 {
			 if(set.contains(i+1))
			 {
				 counter=counter+i;
			 }
		 }
		  return counter;
	 }
	 
	 
}
/*
 * 
 *  Diamond Operator
 *  Luckily, the diamond operator, <>, was added to the language.
 *   The diamond operator is a shorthand notation that allows you to omit the generic type from the right side of a statement when the type can be inferred. 
 *  It is called the diamond operator because <> looks like a diamond.
 * 
 * */
class DemoCollections {
	
	public static void main(String[] args) {
		ArrayList<Integer> data= new ArrayList<>();
		data.add(1);
		data.add(12);
		data.add(13);
		Iterator<Integer> iterator=data.iterator();
		while(iterator.hasNext())
		{
			
			if(iterator.next()>0){
				//safe way 
				iterator.remove();
				//data.remove(val);//unsafe while itrating as it is fail first 
			}
		}
		System.out.println("Done");
	}
}
//=========================================================

/*
 List --> Types of List
 ArrayList -->   Resizable array  -->< good for accessing  as its index but adding/delete not good
 
 LinkedList --> is special because it implements both list and Queue . It has all the methods of Lists 
 It also has additional methods to facillate adding or removing from the beginning and or /end of the list 
 add/update is constant time where search is linear  
 
 
 * 
 * */

//-----------------------Set-----------------------
/*
 
 HashSet---> keys are hash and values are Objects 
     adding and checking wherther an element is the set both have constnt time .
 TreeSet -->     sorted but add/get will be longer than HashSet as tree grows
 
 * 
 * */

//------------------------------Queue Implementations 
/*
 LinkedList ---> Its double-ended queue 
 
 
 
 
 * 
 * 
 * */

class DemopLinked
{
		public static void main(String[] args) {
			LinkedList<Integer> list=new LinkedList<Integer>();
			list.offer(10);
			list.offer(4);
			System.out.println(list.peek());
			System.out.println(list.peek());
			System.out.println(list.poll());
			System.out.println(list.peek());
			
			System.out.println(list);
		}
}



//===================================================MAP

/*
 		Key Value
 		
HashMap --->  stores the keys in a hash table 
 		adding and getting the element by key both have constant time , the trade off is thay ou lose the order 
 		
LinkedHashMap --> keeps the order
TreeMap -=--> stores the keys in sorted order


MAP--> getOrDefault/putIfAbsent/merge method is example default method in interface 
//reversed() in Comparator is example default method

 * 
 * 
 * */
class DemoMap
{
	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("A", 10);
		map.merge("A",100,(o,n)-> o*100);
		System.out.println(map.get("A"));
		map.entrySet().forEach((e)->System.out.print(e.getKey()+"====="+e.getValue()));
		map.values().forEach((v)->System.out.println(v));
		System.out.println(map.getOrDefault("AB", 10*90));
		map.putIfAbsent("A", 100);
		
	}
}

//Sorting Data
/*
 java.lang.Comparable Interface --> CompareTo(other) method 
 java.util.Comparator Interface  --> compare(o1,ob2)
  1 this object greater 
  -1 this object less
  0 this object same
  compareTo() is said to be consistent with equals if, and only if, x.equals(y) is true whenever x.compareTo(y) equals 0.
 * 
 * */
class Node implements Comparable<Node>  , Comparator<Node>
{
	int weight;
	public Node(int w) {
		weight=w;
	}
	public String toString()
	{
		return ""+weight;
	}
	public int getWeight()
	{
		return weight;
	}
	@Override
	public int compareTo(Node other)
	{
		Comparator<Integer> s=null;
	
	     if(this.weight>other.weight)
	     {
	    	 return 1;
	     }
	     else if(this.equals(other))
	     {
	    	 return 0;
	     }
	     return -1;
	     
	}
	
	public int compare(Node o1, Node o2)
	{
		if(o1.equals(o2))
		{
			return 0;
		}
		else if(o1.weight>o2.weight)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
}

class DemoSort
{
	public static void main(String[] args) {
		Node n=new Node(30);
		Node n2=new Node(20);
		List<Node> lst= new ArrayList<Node>();
		lst.add(n);
		lst.add(n2);
		
		var c=Comparator.comparing(Node::getWeight).reversed();
		//both are same
		Comparator<Node> d=Comparator.reverseOrder();
		Collections.sort(lst, d);
		
		System.out.println(lst);
		
	}
}


//================SEARCHING


class DemoSort2
{
		public static void main(String[] args) {
			Node n1= new Node(10);
			Node n2= new Node(10);
			List<Node> lst=new LinkedList<Node>();
			lst.add(n1);
			lst.add(n2);
			var c=Comparator.comparing(Node::getWeight);
			Collections.binarySearch(lst,n1);
			
			
			
		}
}
	

//-=------------------Generics ===============================

class DemoNonGeneric
{
	
	public static void main(String[] args) {
		List lst=new ArrayList();
		lst.add("Java");
		lst.add(10);
		lst.add(0x10);
		lst.add(new Node(10));
		test(lst);
		testGeneric(lst);
	}
	
	static void test(List lst)
	{
		for(Object data : lst)
		{
			
			System.out.print(((String)data).length());
		}
	}
	static void testGeneric(List<String> lst)
	{
			lst.forEach(System.out::println);
	}
}

// Generic Classess-----

class GNode<T> implements Comparable<T>
{
		public T weight;
		public GNode(T wt)
		{
			weight=wt;
		}
		public T getWeight()
		{
			return weight;
		}
		
		public int compareTo(T other)
		{
			return this.compareTo(other);
		}
}
class GTree<T,U> 
{
	public GNode<T> node;
	public List<U> branch;
	
}
class DemoGeneric3
{
	 public static void main(String[] args) {
		GNode<Integer> data= new GNode<>(10);
		System.out.println(data.weight);
		int salary=15_000;
		System.out.println(salary);
	}
}
/*
 When you have a method declare a generic parameter type, it is independent of the class generics.
  Take a look at this class that declares a generic T at both levels:
 1: public class Crate<T> {
2:    public <T> T tricky(T t) {
3:       return t;
4:    }
5: }

10: public static String createName() {
11:    Crate<Robot> crate = new Crate<>();
12:    return crate.tricky("bot");
13: }
 * 
 * */



//--- Bounded Generic Types 
/*
 
 Bounded wildcards solve this by restricting what types can be used in a wildcard. A bounded parameter type is a generic type that specifies a bound for the generic. Be warned that this is the hardest section in the chapter,
  so don't feel bad if you have to read it more than once.
 
 
 * 
 * */

class GNxtNode
{
	public void add(GNode<? extends Number> node)
	{
		
	}
	public void add2(GNode<? extends Exception> node) {}
	public void add3(GNode<? super Exception> node) {}
	public void call()
	{
		GNode<Integer> intnode= new GNode(10);
		add(intnode);
		add2(new GNode<RuntimeException>(new RuntimeException()));
		add3(new GNode<Throwable>(new RuntimeException()));
		
	}
}































