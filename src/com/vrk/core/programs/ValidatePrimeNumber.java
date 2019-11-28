package com.vrk.core.programs;

public class ValidatePrimeNumber {

	public static void main(String[] args) {

		int num = 15, flag = 0;

		if (num == 0 || num == 1) {
			System.out.println("given number is not prime :" + num);
		}

		for (int i = 2; i < num / 2; i++) {

			if (num % i == 0) {

				System.out.println("given number is not prime :" + num);
				flag = 1;
				break;
			}
		}

		if (flag == 0) {
			System.out.println("given numer is prime :" + num);
		}

	}

}
