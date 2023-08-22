package com.java.javaproject;

import java.util.ArrayList;
import java.util.List;

public class ArrayListVsLinkedList {
	
	public static long getMemoryUsage() {
		Runtime runtime= Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}

	public static void main(String[] args) {
		
		List<Integer> arrayList = new ArrayList<>();
		
		long startTime, endTime;
		long memoryBefore, memoryAfter;
		
		startTime= System.nanoTime();
		memoryBefore = getMemoryUsage();
		
		for(int i =0; i<10000 ;i++) {
			arrayList.add(i);
		}
		
		memoryAfter = getMemoryUsage();
		
		long spaceComplexityInsertion = memoryAfter - memoryBefore;
		
		 endTime = System.nanoTime();
		 long arrayListComplexityInsertion = endTime - startTime;
		 
		 arrayList.remove(900);
		 memoryAfter = getMemoryUsage();
		 long spaceComplexityDeletion = memoryAfter - memoryBefore;
		 
		 endTime = System.nanoTime();
		 
		 long arrayListComplexityDeletion= endTime -startTime;
		 
		 System.out.println("********ARRAY LIST***********");
			System.out.println("ArrayList Time Complexity for Insertion		:" + arrayListComplexityInsertion+ " ns ");
			System.out.println("ArrayList Space Complexity for Insertion	:" + spaceComplexityInsertion+ " bytes ");
			System.out.println("ArrayList Time Complexity for Deletion		:" +arrayListComplexityDeletion + " ns");
			System.out.println("ArrayList Space Complexity for Deletion		:" +spaceComplexityDeletion + " bytes");
			

	}

}
