/*
 * 	In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort.
 *  It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than
 *  the similar insertion sort. Selection sort is noted for its simplicity, and it has performance advantages
 *  over more complicated algorithms in certain situations, particularly where auxiliary memory is limited.
 *  
 *  The algorithm divides the input list into two parts: 
 *  the sublist of items already sorted, which is built up from left to right at the front (left) of the list, 
 *  and the sublist of items remaining to be sorted that occupy the rest of the list. 
 *  Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. 
 *  The algorithm proceeds by finding the smallest (or largest, depending on sorting order) 
 *  element in the unsorted sublist, exchanging it with the leftmost unsorted element (putting it in sorted order), 
 *  and moving the sublist boundaries one element to the right.
 */
package com.sharad.algos.sorting.selection;

import com.sharad.algos.common.RandomGenerator;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		Integer[] input = RandomGenerator.getRandomIntegers(20);
		System.out.println("Input Array");
		RandomGenerator.printArray(input);
		selectionSort.sort(input);
		System.out.println("Sorted Array");
		RandomGenerator.printArray(input);
	}

	private void sort(Integer[] input) {
		int minIdx;
		int i;
		int j;
		int temp;
		for (i = 0; i < input.length - 1; i++) {
			minIdx = i; // selecting an index and assuming this index holds
						// smallest value
			for (j = minIdx + 1; j < input.length; j++) { 	// scan rest of the
															// array to check
															// our assumption
				if (input[j] < input[minIdx]) { // our assumption breaks
					minIdx = j; 				// update the index of smallest value
				} 								// continue scanning until reach end of list
			}
			if (minIdx != i) { 	// compare the initial value of minIdx with the
								// value after scanning if they
								// don't match swap elements
				temp = input[i];
				input[i] = input[minIdx];
				input[minIdx] = temp;
			}
		}
	}
}
