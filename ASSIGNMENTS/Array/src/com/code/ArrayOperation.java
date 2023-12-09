package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.List.*;
import java.util.Scanner;
import static com.validate.ValidateK.validateKValue;
import com.exp.ArrayExp;

public class ArrayOperation {
public static void main(String[] args) throws ArrayExp {
	try(Scanner sc=new Scanner(System.in))
	{
		System.out.println("Enter array size");
		int size=sc.nextInt();
		Integer[] arr=new Integer[size];
		
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter element at " +i+"th position: (Elements must be distinct) ");
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Enter kth number to display kth smallest element in array:  ");
		
		int k=validateKValue(sc.nextInt(), size);
		
		Arrays.sort(arr);
		
		System.out.println("Smallest "+k+"th element in array is: "+arr[k-1]);
		
//		System.out.println("Display array: ");
//		for(int i:arr)
//		{
//			System.out.print(i+" ");
//		}
//		

	}
	
}
}
