package com.micro_soft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci_prefix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Integer> fibonaci_index_map = getFibonaciMap();
		while (in.hasNext()) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(solve(arr, n, fibonaci_index_map));
		}
		in.close();
	}

	// num -> index
	static Map<Integer, Integer> getFibonaciMap() {
		Map<Integer, Integer> res = new HashMap<>();
		int a = 1;
		int b = 1;
		res.put(1, 2);
		for (int i = 3; i < 400; i++) {
			b = a + b;
			res.put(b, i);
			a = b - a;
		}
		return res;
	}

	static int solve(int arr[], int n, Map<Integer, Integer> fibonaci_index_map) {
		int res[] = new int[400];

		for (int i = 0; i < n; i++) {
			int num = arr[i];
			if (!fibonaci_index_map.containsKey(num))
				continue;
			int index = fibonaci_index_map.get(num);
			res[index] = (res[index] + res[index - 1]) % 1000000007;
			if (num == 1)
				res[1] += 1;
		}

		int answer = 0;
		for (int i = 0; i < res.length; i++) {
			answer = (answer + res[i]) % 1000000007;
		}

		return answer;
	}

}
