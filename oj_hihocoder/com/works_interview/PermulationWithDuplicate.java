package com.works_interview;

import java.util.ArrayList;
import java.util.List;

public class PermulationWithDuplicate {

	public static void main(String[] args) {
//		System.out.println(SolutionPermulationWithDuplicate.permulationNoDuplicate("aab").toString());
		new PermutationOther().permutation("12345");
	}

}

class SolutionPermulationWithDuplicate {

	public static List<String> permulationNoDuplicate(String str) {
		List<String> res = new ArrayList<>();
		if (str.length() == 0)
			return res;
		per_all(str.toCharArray(), 0, str.length() - 1, res);
		return res;
	}

	private static void per_all(char ch[], int start, int end, List<String> res) {

		if (start == end) {
			res.add(new String(ch));
			return;
		}

		for (int i = start; i <= end; i++) {

			if (!is_occur(ch, start, i)) {

				swap(ch, start, i);
				per_all(ch, start + 1, end, res);
				swap(ch, start, i);
			}
		}

	}

	private static void swap(char ch[], int a, int b) {
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
	}

	private static boolean is_occur(char[] ch, int start, int index) {
		char c = ch[index];
		for (int i = start; i < index; i++) {
			if (ch[i] == c)
				return true;
		}
		return false;
	}

}

class PermutationOther {
	private char[] data;
	private int length;

	private void swap(char[] s, int a, int b) {
		char c = s[a];
		s[a] = s[b];
		s[b] = c;
	}

	private void reverse(char[] s, int a, int b) {
		for (; a < b; a++, b--)
			swap(s, a, b);
	}

	private boolean next() {
		int start = length - 1, end = length - 1;
		while (start > 0 && data[start] < data[start - 1])
			start--;
		if (start == 0)
			return false;
		while (data[start - 1] > data[end])
			end--;

		swap(data, start - 1, end);
		reverse(data, start, length - 1);
		return true;
	}

	public void permutation(String str) {
		length = str.length();
		data = str.toCharArray();

		// 选择排序
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++)
				if (data[min] > data[j])
					min = j;
			swap(data, min, i);
		}

		System.out.println(data);
		while (next()) {
			System.out.println(data);
		}
	}

}