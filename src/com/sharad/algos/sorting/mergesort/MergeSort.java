package com.sharad.algos.sorting.mergesort;

import com.sharad.algos.common.RandomGenerator;
import com.sharad.algos.common.Utility;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		Integer[] input = RandomGenerator.getRandomIntegers(20);
		Integer[] auxArray = new Integer[input.length];
		System.out.println("Input Array");
		Utility.printArray(input);
		mergeSort.sort(input, auxArray);
		System.out.println("Sorted Array");
		Utility.printArray(input);
	}

	private void sort(Integer[] input, Integer[] auxArray) {
		int minIdx, maxIdx;
		minIdx = 0;
		maxIdx = input.length - 1;
		sort(input, auxArray, minIdx, maxIdx);
	}

	private void sort(Integer[] input, Integer[] auxArray, Integer minIdx,
			Integer maxIdx) {
		if (minIdx < maxIdx) {
			Integer midIdx = (minIdx + maxIdx) / 2;
			sort(input, auxArray, minIdx, midIdx);
			sort(input, auxArray, midIdx + 1, maxIdx);
			merge(input, auxArray, minIdx, midIdx, maxIdx);
		}
	}

	private void merge(Integer[] input, Integer[] auxArray, Integer minIdx,
			Integer midIdx, Integer maxIdx) {
		// first copy the elements to aux array
		int i, j, k;
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("minIndex :: " + minIdx + " maxIndex ::" + maxIdx
				+ " midIndex ::" + midIdx);
		for (i = minIdx; i <= maxIdx; i++)
			auxArray[i] = input[i];
		Utility.printArray(auxArray);

		i = minIdx;
		j = midIdx + 1;
		k = minIdx;
		
		while (i <= midIdx && j <= maxIdx) {
			if (auxArray[i] <= auxArray[j])
				input[k++] = auxArray[i++];
			else
				input[k++] = auxArray[j++];
		}
		
		while (i <= midIdx) {
			input[k++] = auxArray[i++];
		}
	}
}