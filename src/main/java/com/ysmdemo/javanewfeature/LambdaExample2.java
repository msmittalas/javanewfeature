package com.ysmdemo.javanewfeature;

import java.util.Arrays;

public class LambdaExample2 {

	public static void main(String[] args) {
		int [] arr=new int[] {1,34,53,2,10,20};
		sortAndPrint(arr,
				ar -> Arrays.sort(ar),
				ar->System.out.println("sorted")
				);
		

		
		
	}
	
	public static void sortAndPrint(int arr[], Sort strategy,Print printStrategy) {
		
		strategy.sort(arr);
		printStrategy.print(arr);
		
	}
	
	
}

@FunctionalInterface
interface Print
{
	public void print(int []a);
}

@FunctionalInterface
interface Sort
{
		public void sort(int []array);
		
		default void bubbleSort(int [] arr)
		{
			System.out.println("bubble sort");
			Arrays.sort(arr);
		}
		static void staticBubbleSort(int [] arr)
		{
			System.out.println(" static bubble sort");
			Arrays.sort(arr);
		}
}