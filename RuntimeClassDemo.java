package com.ankur;

/*A Class to demonstrate how Runtime class can be used to measure free memory and also to perform GC*/
public class RuntimeClassDemo {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long initial_free_memory = rt.freeMemory();
		System.out.println("----System Info----");

		System.out.println("Available Processors "+rt.availableProcessors());
		System.out.println("Free Memory is "+initial_free_memory);
		System.out.println("Total Memory is "+rt.totalMemory());
		System.out.println();
		System.out.println("Lets create Strings");
		
		for(int i=0;i<100000;i++) {
			String s = new String("xy "+i);
			s.length();
		}
		long string_free_memory = rt.freeMemory();
		System.out.println();
		System.out.println("Free memory post String creation is "+string_free_memory);
		System.out.println("Let's do GC now");
		rt.gc();
		long reclaimed = initial_free_memory-string_free_memory;
		System.out.println("Memory reclaimed post GC is "+reclaimed);
		System.out.println("Free memory post GC is "+rt.freeMemory());
	}

}
