package com.micro_soft;

import java.util.ArrayList;
import java.util.Scanner;

public class Memory_Allocating_Algorithm_108 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), m = in.nextInt();

		ArrayList<Span> container = new ArrayList<>();
		container.add(new Span(0, m - 1, true, 0));

		for (int i = 1; i <= n; i++) {
			int size_of_i = in.nextInt();

			int index = allocateMemory(container, size_of_i);
			while (index == -1) {
				releaseMemory(container);
				index = allocateMemory(container, size_of_i);
			}

			Span now = container.get(index);
			if (now.end - now.start + 1 == size_of_i) {
				now.empty_or_not = false;
				now.fead_val = i;
			} else {
				Span one = new Span(now.start, now.start + size_of_i - 1, false, i);
				Span two = new Span(now.start + size_of_i, now.end, true, 0);
				container.add(index + 1, one);
				container.add(index + 2, two);
				container.remove(now);
			}
		}

		for (int i = 0; i < container.size(); i++) {
			Span now = container.get(i);
			if (!now.empty_or_not) {
				System.out.println(now.fead_val + " " + now.start);
			}
		}

		in.close();
	}

	static int allocateMemory(ArrayList<Span> container, int size) {
		for (int i = 0; i < container.size(); i++) {
			Span now = container.get(i);
			if (now.empty_or_not && (now.end - now.start + 1) >= size)
				return i;
		}
		return -1;
	}

	static void releaseMemory(ArrayList<Span> container) {
		int index = -1;

		for (int i = 0; i < container.size(); i++) {
			Span now = container.get(i);
			if (!now.empty_or_not) {

				if (index == -1) {
					index = i;
				} else {
					if (now.fead_val < container.get(index).fead_val)
						index = i;
				}
			}
		}

//		System.out.println(index);
//		System.out.println(container.toString());

		Span now = container.get(index);
		now.empty_or_not = true;
		now.fead_val = 0;
		if (index == 0 && container.size() != 1) {
			Span next = container.get(index + 1);
			if (next.empty_or_not) {
				now.end = next.end;
				container.remove(next);
			}

		} else if (index == container.size() - 1 && container.size() != 1) {
			Span pre = container.get(index - 1);
			if (pre.empty_or_not) {
				now.start = pre.start;
				container.remove(pre);
			}

		} else {
			Span next = container.get(index + 1);
			Span pre = container.get(index - 1);

			if (next.empty_or_not) {
				now.end = next.end;
				container.remove(next);
			}

			if (pre.empty_or_not) {
				now.start = pre.start;
				container.remove(pre);
			}
		}

	}

}

class Span {
	int start, end;
	boolean empty_or_not;
	int fead_val;

	public Span(int start, int end, boolean empty_or_not, int fead_val) {
		this.start = start;
		this.end = end;
		this.empty_or_not = empty_or_not;
		this.fead_val = fead_val;
	}

	public String toString() {
		return start + " " + end + " " + empty_or_not + " " + fead_val;
	}
}