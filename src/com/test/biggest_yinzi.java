package com.test;

public class biggest_yinzi {

	public static void main(String[] args) {
		long s1 = System.currentTimeMillis();
//		System.out.println(fibb_no_mem(50));
		long e1 = System.currentTimeMillis();

		System.out.println((e1 - s1));

		long s2 = System.currentTimeMillis();
		long mem[] = new long[55];
		System.out.println(fibb_with_mem(50, mem));
		long e2 = System.currentTimeMillis();
		System.out.println((e2 - s2));
	}

	static int biggest(int a, int b) {

		if (a > b)
			return biggest(b, a);

		if (b % a == 0)
			return a;
		else
			return biggest(a, b % a);
	}

	static long fibb_no_mem(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibb_no_mem(n - 1) + fibb_no_mem(n - 2);
		}

	}

	static long fibb_with_mem(int n, long[] mem) {

		if (mem[n] != 0)
			return mem[n];

		if (n == 1 || n == 2) {
			mem[n] = 1;
		} else {
			mem[n] = fibb_with_mem(n - 1, mem) + fibb_with_mem(n - 2, mem);
		}

		return mem[n];
	}

}
