package com.sharad.algos.common;

public class Utility {
	public static void printArray(Integer[] input) {
		int i = 0;
		for (Integer integer : input) {
			if (i + 1 < input.length) {
				System.out.print(integer + ",");
			} else {
				System.out.println(integer);
			}
			i++;
		}
	}
}
