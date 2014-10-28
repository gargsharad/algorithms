package com.sharad.algos.sorting.heapsort;

import com.sharad.algos.common.RandomGenerator;
import com.sharad.algos.common.Utility;

/*

 The binary heap data structures is an array that can be viewed as a complete binary tree. 
 Each node of the binary tree corresponds to an element of the array. The array is comple-
 -tely filled on all levels except possibly lowest.
 
 The root of the tree A[0] and given index i of a node, the indices of its parent, left c-
 -hild and right child can be computed
    PARENT 	of node at index i will be at index = (i-1)/2
    LEFT  	child of the node will be at index = 2i+1
    RIGHT 	child of the node will be at index = 2i+2
	lets say the length of a given array is 10 and we have 5 elements in it
	then by the definition of parent
	
	parent of element at index 7 will be 3rd leaf 
	parent of element at index 6 will be 3rd leaf 
	parent of element at index 5 will be 2nd leaf
	parent of element at index 4 will be 2nd leaf
	parent of element at index 3 rooted at index 1  and parent of 6 and 7
	parent of element at index 2 rooted at index 0  and parent of 5 and 6
	parent of element at index 1 rooted at index 0  and parent of 3 and 4
	parent of element at index 0 will root node and parent of 1 and 2
	
	So all the nodes in the array with index (length/2)+1 are leaf nodes use this fact to 
	create the procedure of heapify.
	
	start with the index of last non leaf node 
		
	start from the index of last non null element of array.
	find its left child if exists 
		compare its value with child value if parent less then child then swap
		assign value of child index to root index and repeat
	find its right child if exists
		compare its value with child value if parent less then child then swap
		assign value of child index to root index and repeat
	repeat until we reach index 0 root of the tree  
	 
 */

public class HeapSort {
	// We can use the procedure 'Heapify' in a bottom-up fashion to convert an
	// array A[1 . . n] into a heap. Since the elements in the subarray A[n/2 +1
	// . . n] are all leaves, the procedure BUILD_HEAP goes through the
	// remaining nodes of the tree and runs 'Heapify' on each one. The bottom-up
	// order of processing node guarantees that the subtree rooted at children
	// are heap before 'Heapify' is run at their parent.
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		System.out.println("Starting Heap sort ..........");
		Integer[] input = RandomGenerator.getRandomIntegers(2000);
		System.out.println("Unsorted  input array........");
		Utility.printArray(input);
		heapSort.sort(input);
		System.out.println("Sorted Output array .........");
		Utility.printArray(input);
		System.out.println("Exiting Heap sort ...........");
	}

	private void sort(Integer[] input) {
		buildHeap(input);
		/*int temp;
		for (int i = input.length - 1; i >= 1; i--) {
			temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			heapify(input, 0, i - 1);
		}*/
	}

	private void buildHeap(Integer[] input) {
		for (int i = (input.length/2) - 1; i >= 0; i--) {
			heapify(input, i, input.length-1);
		}
	}

	private void heapify(Integer[] input, int rootIndex, int bottomIndex) {
		int maxChild, temp;
		boolean done = false;
		while ((rootIndex * 2 <= bottomIndex) && (!done)) {

			if (rootIndex * 2 == bottomIndex) {
				maxChild = rootIndex * 2;
			} else if (input[rootIndex * 2] > input[rootIndex * 2 + 1]) {
				maxChild = rootIndex * 2;
			} else {
				maxChild = rootIndex * 2 + 1;
			}

			if (input[rootIndex] < input[maxChild]) {
				temp = input[rootIndex];
				input[rootIndex] = input[maxChild];
				input[maxChild] = temp;
				rootIndex = maxChild; //--- this is the key
			} else {
				done = true;
			}
		}
	}
}