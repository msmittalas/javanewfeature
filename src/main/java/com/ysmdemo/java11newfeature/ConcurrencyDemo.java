package com.ysmdemo.java11newfeature;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;


public class ConcurrencyDemo {

	
	public static void main(String[] args)  {
		Runnable r=new CyclicBarrierDemo();
		r.run();
	}

	
	
}
/*
 Threading Problems : 
	Liveness : 
	 is an ability of an application to be able to execute in a timely manner 
	 Liveness problems , then are those in which the application becomes unrespo or some kind of stuck state 
	 Deadlock : occurs when two or more threads are blocked forever. each wiating on the other
	  how to fix ? you cant fix it but you can avoid it by strategically putting synchroinzed keyword
	  
	 Starvation: occurs when a single thread is prepetually denied access to shared resource . he is not getting chance
	 LiveLock :If Foxy and Tails continue this process forever, 
	 it is referred to as livelock. Both Foxy and Tails are active, 
	 running back and forth across their area, but neither is able to finish their meal.
	  Foxy and Tails are executing a form of failed deadlock recovery. Each fox notices that they are potentially entering a deadlock state and responds by 
	  releasing all of its locked resources. Unfortunately, the lock and unlock process is cyclical,
	   and the two foxes are conceptually deadlocked. 
	  Race condition : is an undesirable result that occurs when two tasks completed at the same time.
	   Both users are able to create accounts with username ZooFan.
*/	

/*
 If I get collection which is not from concurrent API then how will make synchronized ?>
 OBTAINING SYNCHRONIZED COLLECTIONS
 the Concurrency API also includes methods for obtaining synchronized versions of existing nonconcurrent collection objects. .
 These synchronized methods are defined in the Collections class.
 
 * COncurrentSkipListSet ----> 
 * 	SkipList classes , --> ConcurrentSkipListSet --> TreeSet 
 * 	ConcurrentSkipList -->TreeMap  
 *  CopyOnWrite Collections ---> This classes copy all the data to new structure anytime an element is added/modified/removed
    Although the data is copied to a new underlying structure, our reference to the Collection object does not change.
     This is particularly useful in multithreaded environments that need to iterate the collection. Any iterator
      established prior to a modification will not see the changes, 
    but instead it will iterate over the original elements prior to the modification.
 *  CopyOnWriteArrayList  -->
 *  CopyOnWriteArraySet--> 
 *  
 *  he final collection class in Table 18.9 that you should know for the exam is the LinkedBlockingQueue, which implements the BlockingQueue interface. The BlockingQueue is just like a regular Queue,
 *   except that it includes methods that will wait a specific amount of time to complete an operation.
 * */


/*
 * CyclicBarrier  -> Orchestrating tasks
 *    
 * 
 * */

class CyclicBarrierDemo implements Runnable
{
	public void run()
	{
		ExecutorService service=Executors.newFixedThreadPool(3);
		CyclicBarrier barrier=new CyclicBarrier(3);
		service.submit(new SomeTasks(barrier, "H1"));
		service.submit(new SomeTasks(barrier, "H2"));
		service.submit(new SomeTasks(barrier, "H3"));
		
		service.shutdown();
		
		
		
	}
}
class SomeTasks implements Runnable
{
	CyclicBarrier barrier;
	String s1;
	
	
	public SomeTasks(CyclicBarrier b,String s) {
		barrier=b;
		s1=s;
	}
	
	public void run()
	{
		Consumer<String> data=System.out::println;
		Consumer<String> data2=s->System.out.println("Random value for "+s+" is"+Math.random());
		Consumer<String> data3=s->System.out.println("ok tata bye bye...");
		
		data.accept(s1);
		try {
			barrier.await();
			data2.accept(s1);
			barrier.await();
			data3.accept(s1);
			
			
			
			
			
		} catch (Exception e) {
		}
		
		
		
	}
}


/*
 * 
 * Lock Framework
 * 
 * 
 * 
 * */
class SimulateAccountWidDemo implements Runnable{
	
	public void run()
	{
		Lock lock=new ReentrantLock();
		Account account =new Account(lock);
		ExecutorService service=Executors.newFixedThreadPool(5);
		service.submit(new Person(account, 1000));
		service.submit(new Person(account, 1200));
		
		service.shutdown();
	}
	
	
}
class Person implements Runnable
{
	Account account;
	int amt;
	public Person(Account account,int amt) {
	 this.account=account;
	 this.amt=amt;
	}
	public void wid(int amount)
	{
		account.deduct(amount);
	}
	public void run()
	{
		wid(amt);
	}
}

class  Account 
{
		int balance=2000;
		Lock lock;
		public Account(Lock lc) {
		lock=lc;
		}
		
		public void deduct(int amount)
		{

			
			try {	
				lock.lock();
			if(getBalance()>amount)
			{
				balance=balance-amount;
				System.out.println(amount+"amount deducted , current balance is "+balance+" thread-->"+Thread.currentThread().getName());
			}
			else
			{
				System.err.println("No Balance"+Thread.currentThread().getName());
				throw new RuntimeException("No Balance");
				
			}
			}finally  {
			
				lock.unlock();
				
			}
			
		}
		public int getBalance()
		{
			System.out.println("Balance is"+balance+" and called by "+Thread.currentThread().getName());
			return this.balance;
		}
}






/*
Thread Safety---Data safety
normal data types are not thread safe example see below 
Use Atomic classes for  
Atomic is the property of an operation to be carried out as a single unit of execution without
 any interference by another thread. A thread‐safe atomic version of the increment operator 
 would be one that performed the read and write of the variable as a single operation,
 not allowing any other threads to access the variable during the operation. 

 * */
class ThreadSafeDemo implements Runnable
{
	public void run()
	{
		CounterServiceThreadSafeandSynchronized countService =new CounterServiceThreadSafeandSynchronized();
		ExecutorService service= Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++)
		{
			service.submit(countService::count);
		}
		service.shutdown();
		
	}
}
class NotThreadSafeDemo implements Runnable
{
	public void run()
	{
		CounterService countService =new CounterService();
		ExecutorService service= Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++)
		{
			service.submit(()->countService.run());
		}
		service.shutdown();
	}
	
	
}
class CounterServiceThreadSafeandSynchronized
{
	AtomicInteger counter= new AtomicInteger(0);
	synchronized public void count()
	{
		System.out.println(counter.incrementAndGet());
	}
}

//CounterService is not thread -safe 
class CounterService 
{
	int count=0;
	
	public void run()
	{
		System.out.println(++count);
	}
}


/*
 ScheduledExecutorService   
 
 * 
 * 
 * */
class ScheduledDemo implements Runnable
{
		public void run()
		{
			try {
				//   Runtime.getRuntime().availableProcessors()
			ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
			service.scheduleAtFixedRate( ()->System.out.println("Hello from Schedule"),2, 2, TimeUnit.SECONDS);
			System.out.println("started");
			//service.shutdown();
			service.awaitTermination(10, TimeUnit.SECONDS);
			}catch(Exception e) {e.printStackTrace();}
		}
}

/*
 
 Demo ExecutorService ---> 
  
 * 
 * 
 * */

class ThreadExecutorServiceDemo implements Runnable
{
		public void run()
		{
			try {
				System.out.println("Start");
			Work work=new Work(System.out::println ,"Data Work");
			Work work2=new Work(System.out::println ,"Download...");
			ExecutorService service=Executors.newFixedThreadPool(4);
			service.submit(work);
			service.submit(work2);
			Callable<String> workAndReturn= ()->{Thread.sleep(5*1000); return "Hello";};
			Future<String> data=service.submit(workAndReturn);
			
			service.shutdown();
			service.awaitTermination(1, TimeUnit.MINUTES);
			System.out.println(service.isTerminated());
			//while(!data.isDone()) {}
			System.out.println(data.get(7,TimeUnit.SECONDS));
			}
			catch(Exception e) {e.printStackTrace();}
			
			
		}
}



class Work implements Runnable
{
	Consumer<String> function;
	String inputString;
	public Work(Consumer<String> function,String input) {
		this.function=function;
		inputString=input;
	}
	
	
	public void run()
	{
		function.accept(inputString);
	}
	

}
