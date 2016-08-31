package com.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class huawei_zui_gao_fen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			int n = in.nextInt(), m = in.nextInt();
			int rem_index[] = new int[n + 1];

			ArrayList<Student> container = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int s = in.nextInt();
				container.add(new Student(i + 1, s));
			}

			Collections.sort(container);

			for (int i = 0; i < container.size(); i++) {
				Student now = container.get(i);
				rem_index[now.no] = i;
			}

			for (int i = 0; i < m; i++) {
				String ch = in.next();
				int a = in.nextInt(), b = in.nextInt();

				// System.out.println(ch+" "+a+" "+b);

				if (ch.equals("Q")) {
					if(a>b){
						a=a+b;
						b=a-b;
						a=a-b;
					}
					
					int biggest = a;
					for (int j = a + 1; j <= b; j++) {
						if (rem_index[j] > rem_index[biggest])
							biggest = j;
					}

					System.out.println(container.get(rem_index[biggest]).score);
				} else if (ch.equals("U")) {
					container.remove(rem_index[a]);
					for (int j = rem_index[a]; j < container.size(); j++) {
						Student now = container.get(j);
						rem_index[now.no] = j;
					}

					Student new_s = new Student(a, b);
					int insert_index = find_insert_index(container, new_s);
					container.add(insert_index, new_s);
					rem_index[a] = insert_index;
				} else {
					System.out.println("wrong");

				}
			}
		}

		in.close();
	}

	// 找到第一个比它大的元素位置
	static int find_insert_index(ArrayList<Student> container, Student new_s) {
		int start = 0, end = container.size() - 1;

		if (new_s.compareTo(container.get(start)) <= 0)
			return start;
		if (new_s.compareTo(container.get(end)) >= 0)
			return container.size();

		while (start < end) {

			int mid = (start + end) / 2;

			if (new_s.compareTo(container.get(mid)) > 0) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}

}

class Student implements Comparable<Student> {
	int no, score;

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return score - o.score;
	}

}