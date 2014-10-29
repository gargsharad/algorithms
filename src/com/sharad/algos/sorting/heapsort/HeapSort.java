package com.sharad.algos.sorting.heapsort;

import com.sharad.algos.common.RandomGenerator;
import com.sharad.algos.common.Utility;

/*
 The binary heap data structures is an array that can be viewed as a complete binary tree. 
 Each node of the binary tree corresponds to an element of the array. The array is comple-
 -tely filled on all levels except possibly lowest.

 The root of the tree A[0] and given index i of a node, the indices of its parent, left c-
 -hild and right child can be computed
	 PARENT 	of node at index i will be at index = (i)/2
	 LEFT  	child of the node will be at index = 2i+1
	 RIGHT 	child of the node will be at index = 2i+2

 Heapify process:
	 Heapify is a procedure for manipulating heap data structures. It is given an array 
	 A and index i into the array. The subtree rooted at the children of A[i] are heap 
	 but node A[i] itself may possibly violate the heap property i.e., A[i] < A[2i] or A[i] < A[2i +1].
	 The procedure 'Heapify' manipulates the tree rooted at A[i] so it becomes a heap. 
	 In other words, 'Heapify' is let the value at A[i] "float down" in a heap so that 
	 subtree rooted at index i becomes a heap.

 Heapsort: Create heap first
	 while(n>=1){
		 get the largest element [at index 0 ]from heap store swap it with last 
		 element of array [at index n-1]
		 n=n-1
		 run heapify for the elements in the sub array array[0, n-1]
 	} 	 
*/

public class HeapSort {
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		System.out.println("Starting Heap sort ..........");
		Integer[] input = RandomGenerator.getRandomIntegers(10);
		int size = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != null)
				size += 1;
		}
		System.out.println("Unsorted  input array........");
		Utility.printArray(input);
		heapSort.sort(input, size);
		System.out.println("Sorted Output array .........");
		Utility.printArray(input);
		System.out.println("Exiting Heap sort ...........");
	}

	private void sort(Integer[] input, int size) {
		buildHeap(input, size);
		System.out.println("Printing Heap ...........");
		Utility.printArray(input);
		int temp;
		for (int i = size - 1; i >= 1; i--) {
			temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			heapify(input, 0, i - 1);
		}
	}

	private void buildHeap(Integer[] input, int size) {
		for (int i = (((size) - 1) / 2); i >= 0; i--) {
			heapify(input, i, size - 1);
		}
	}
	private void heapify(Integer[] input, int rootIndex, int bottomIndex) {
		int maxChild, temp;
		boolean done = false;
		System.out.println("?????");
		while (((rootIndex * 2) <= bottomIndex) && (!done)) {
			System.out.println("Node at root :: "+ rootIndex + "      "+ input[rootIndex]);
			if ((rootIndex * 2) == bottomIndex) {
				maxChild = (rootIndex * 2);
			} else if (input[rootIndex * 2] > input[rootIndex * 2 + 1]) {
				maxChild = rootIndex * 2;
			} else {
				maxChild = rootIndex * 2 + 1;
			}
			if (input[rootIndex] < input[maxChild]) {
				System.out.println("Node are swapped with values :: root index :: "+rootIndex+" value ::: " + input[rootIndex]+ "   Max child index ::: "+ maxChild+" value ::: "+ input[maxChild]);
				temp = input[rootIndex];
				input[rootIndex] = input[maxChild];
				input[maxChild] = temp;
				// --- this is the key; after swapping we need to check further whether 
				// the heap property is satisfied further down the heap
				rootIndex = maxChild;
			} else {
				done = true;
				System.out.println("################");
			}
		}
	}
}