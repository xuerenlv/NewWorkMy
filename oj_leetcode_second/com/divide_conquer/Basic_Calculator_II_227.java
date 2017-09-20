package com.divide_conquer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Basic_Calculator_II_227 {

	public static void main(String[] args) {

	}

}

class Solution_Basic_Calculator_II_227 {
	public int calculate_2(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			// 非数字
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	// 先处理乘除，再处理加减
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;

		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int cur = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + s.charAt(i + 1) - '0';
					++i;
				}
				if (!list.isEmpty() && (list.peek() == 2 || list.peek() == 3)) {
					int op = list.pop();
					int opl = list.pop();
					int res = 0;
					if (op == 2)
						res = opl * cur;
					else
						res = opl / cur;
					list.push(res);
				} else {
					list.push(cur);
				}
			} else if (c == ' ')
				continue;
			else {
				switch (c) {
				case '+':
					list.push(0);
					break;
				case '-':
					list.push(1);
					break;
				case '*':
					list.push(2);
					break;
				case '/':
					list.push(3);
					break;
				default:
					return -1;
				}
			}
		}

		if (list.isEmpty())
			return 0;
		Collections.reverse(list);

		int res = list.poll();

		while (!list.isEmpty()) {
			int op = list.poll();
			int opr = list.poll();
			if (op == 0)
				res += opr;
			else
				res -= opr;
		}
		return res;
	}

	// 这个是错误的
	public int calculate__wrong(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return s.charAt(0) - '0';

		Stack<Integer> stack = new Stack<>();
		int current = 0;
		int sign = 1;

		int mul_chu = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int cur = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				if (mul_chu == 0)
					current += sign * cur;
				if (mul_chu == 1)
					current *= sign * cur;
				if (mul_chu == 2)
					current /= sign * cur;
			}
			if (ch == '-') {
				sign = -1;
			}
			if (ch == '+') {
				sign = 1;
			}

			if (ch == '*') {
				mul_chu = 1;
			}
			if (ch == '/') {
				mul_chu = 2;
			}

			if (ch == '(') {
				stack.push(current);
				stack.push(sign);
				stack.push(mul_chu);
				current = 0;
				sign = 1;
				mul_chu = 0;
			}
			if (ch == ')') {
				if (stack.peek() == 0) {
					stack.pop();
					current = stack.pop() * current + stack.pop();
				}
				if (stack.peek() == 1) {
					stack.pop();
					current = stack.pop() * current * stack.pop();
				}
				if (stack.pop() == 2) {
					stack.pop();
					current = stack.pop() * current + stack.pop();
				}
				sign = 1;
				mul_chu = 0;
			}

		}
		return current;
	}
}