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
			merge(input, auxArray, midIdx, midIdx, maxIdx);
		}
	}

	private void merge(Integer[] input, Integer[] auxArray, Integer midIdx,
			Integer midIdx2, Integer maxIdx) {
		
	}
}
