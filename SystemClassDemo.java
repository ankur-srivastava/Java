package com.ankur;

import java.util.ArrayList;
import java.util.Collections;

/*Program to calculate time taken to perform an operation*/
public class SystemClassDemo {

	public static void main(String[] args) {

		long initial_time_ms = System.currentTimeMillis();
		long initial_time_nanos = System.nanoTime();
		long final_time_ms, final_time_nanos;
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=0;i<1000;i++) {
			al.add(i);
		}
		
		Collections.sort(al, null);
		
		final_time_ms = System.currentTimeMillis();
		final_time_nanos = System.nanoTime();
		
		System.out.println("Time taken to execute the code in ms "+(final_time_ms-initial_time_ms));
		System.out.println("Time taken to execute the code in nanos "+(final_time_nanos-initial_time_nanos));
		
	}

}
