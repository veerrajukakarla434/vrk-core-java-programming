package com.vrk.core.programs;

import java.util.Arrays;

public class MaximumRepeatingElementFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 1;
		int maxCount = 1;

		int arrA[] = { 8, 3, 3, 3, 3, 3, 9, 3, 20, 20, 20, 20, 20, 20, 20, 20 };
		Arrays.sort(arrA);
		int relement = arrA[0];

		for (int i = 0; i < arrA.length; i++) {
			if (i + 1 < arrA.length && arrA[i] == arrA[i + 1]) {
				count++;
				if (count > maxCount) {
					maxCount = count;
					relement = arrA[i];
				}

			} else {
				count = 1;
			}
		}

		System.out.println("Maximum Repeated Element is :" + relement + "  Repeated Count is :" + maxCount);

	}

}
