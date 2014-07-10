/*
 * 
 * The bubble sort repeatedly compares adjacent elements of an array. 
 * The first and second elements are compared and swapped if out of order.  
 * Then the second and third elements are compared and swapped if out of order.  
 * This sorting process continues until the last two elements of the array are 
 * compared and swapped if out of order. When this first pass through the array
 * is complete, the bubble sort returns to elements one and two and starts the
 * process all over again.  So, when does it stop?  The bubble sort knows that 
 * it is finished when it examines the entire array and no "swaps" are needed 
 * (thus the list is in proper order).  The bubble sort keeps track of the 
 * occurring swaps by the use of a flag.
 * 
 */

package com.sharad.algos.sorting.bubble;

import com.sharad.algos.common.RandomGenerator;

public class BubbleSort {

	public void sort(Integer[] input) {
		boolean swapped = true; // set flag to true to begin first pass
		int temp;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		Integer[] input = RandomGenerator.getRandomIntegers(20);
		System.out.println("Input Array");
		int i = 0;
		for (Integer integer : input) {
			if (i + 1 < input.length) {
				System.out.print(integer + ",");
			} else {
				System.out.println(integer);
			}
			i++;
		}
		bubbleSort.sort(input);
		i = 0;
		System.out.println("Sorted Array");
		for (Integer integer : input) {
			if (i + 1 < input.length) {
				System.out.print(integer + ",");
			} else {
				System.out.print(integer);
			}
			i++;
		}
	}
}
