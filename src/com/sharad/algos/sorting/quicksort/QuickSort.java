package com.sharad.algos.sorting.quicksort;

import com.sharad.algos.common.RandomGenerator;
import com.sharad.algos.common.Utility;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		Integer[] input = RandomGenerator.getRandomIntegers(20);
		System.out.println("Input Array");
		Utility.printArray(input);
		quickSort.sort(input);
		System.out.println("Sorted Array");
		Utility.printArray(input);
	}

	private void sort(Integer[] input) {
		Integer minIdx = 0;
		Integer maxIdx = input.length - 1;
		sort(input, minIdx, maxIdx);
	}

	private void sort(Integer[] input, Integer minIdx, Integer maxIdx) {
		Integer pivotIdx = null;
		if (minIdx < maxIdx) {
			pivotIdx = partition(input, minIdx, maxIdx);
			sort(input, minIdx, pivotIdx - 1);
			sort(input, pivotIdx + 1, maxIdx);
		}
	}

	private Integer partition(Integer[] input, Integer left, Integer right) {
		Integer pivotIdx = (left + right) / 2;
		Integer pivotVal = input[pivotIdx];
		swap(pivotIdx, right, input); // move piovt element to last element of
										// array this step assumes that pivot
										// has max value
		Integer storeIndex = left; // Here we assume that after all the
									// comparisons the pivot will be stored
									// at min index
		for (int i = left; i < right - 1; i++) {
			if (input[i] <= pivotVal) {
				swap(i, storeIndex, input);
				storeIndex += 1;
			}
		}
		swap(storeIndex, right, input);
		return storeIndex;
	}

	private void swap(Integer pivotIdx, Integer maxIdx, Integer[] input) {
		Integer temp = input[pivotIdx];
		input[pivotIdx] = input[maxIdx];
		input[maxIdx] = temp;
	}
}
