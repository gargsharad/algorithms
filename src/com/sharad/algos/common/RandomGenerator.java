package com.sharad.algos.common;

import java.util.Random;

public class RandomGenerator {
	public static Integer[] getRandomIntegers(Integer range) {
		Integer[] randomInts = new Integer[range];
		Random randomGenerator = new Random();
		for (int idx = 0; idx < range; ++idx) {
			randomInts[idx] = randomGenerator.nextInt(10000);
		}
		return randomInts;
	}
}
