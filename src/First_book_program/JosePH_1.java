package First_book_program;

import java.util.Arrays;

public class JosePH_1 {

	public static void main(String[] args) {

		 System.out.println(joseph_1(6, 2));
		 System.out.println(joseph_1(12, 4));
		 System.out.println(joseph_1(8, 3));
		
		 System.out.println(joseph_2(6, 2));
		 System.out.println(joseph_2(12, 4));
		 System.out.println(joseph_2(8, 3));

		System.out.println(joseph_3(6, 2));
		System.out.println(joseph_3(12, 4));
		System.out.println(joseph_3(8, 3));
	}

	// 数学推导
	static int joseph_1(int n, int m) {
		int s = 0;
		for (int i = 2; i <= n; i++)
			s = (s + m) % i;
		return s + 1;
	}

	// 数组模拟
	static int joseph_2(int n, int m) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int left = n, start = -1, count;
		while (left > 0) {
			// System.out.println(Arrays.toString(arr));
			count = 0;
			while (count != m) {
				start = (start + 1) % n;
				if (arr[start] > 0) {
					count++;
				}

			}
			arr[start] = -1 * left;
			left--;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] > 0)
				start = i;
		}

		return start + 1;
	}

	// 循环链表模拟
	static int joseph_3(int n, int m) {
		DeNode head = new DeNode(1);
		DeNode p = head, q;
		for (int i = 1; i < n; i++) {
			p.next = new DeNode(i + 1);
			p = p.next;
		}
		p.next = head;

		int left = n, count;
		while (left > 0) {
			count = 0;
			while (count != m - 1) {
				count++;
				p = p.next;
			}
			left--;
			q = p;
			p.next = p.next.next;
			q = null;
		}
		return p.val;
	}
}

class DeNode {
	int val;
	DeNode next;

	public DeNode(int a) {
		val = a;
		next = null;
	}
}
