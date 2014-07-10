/**
 * 
 */
package com.sharad.algos.sorting.insertion;

import com.sharad.algos.common.RandomGenerator;
import com.sharad.algos.common.Utility;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		Integer[] input = RandomGenerator.getRandomIntegers(20);
		System.out.println("Input Array");
		Utility.printArray(input);
		insertionSort.sort(input);
		System.out.println("Sorted Array");
		Utility.printArray(input);
	}

	private void sort(Integer[] input) {
		int j, i, key;
		for (i = 1; i < input.length; i++) {
			key = input[i];
			for (j = i - 1; j >= 0 && input[j] > key; j--) {
				input[j + 1] = input[j];
			}
			input[j + 1] = key;
		}
	}
}
