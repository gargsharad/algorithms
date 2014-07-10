package com.sharad.algos.common;

import java.util.Random;

public class RandomGenerator {
	public static Integer[] getRandomIntegers(Integer range) {
		Integer[] randomInts = new Integer[range];
		Random randomGenerator = new Random();
		for (int idx = 0; idx < range; ++idx) {
			randomInts[idx] = randomGenerator.nextInt(1000);
		}
		return randomInts;
	}

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
