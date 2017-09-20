package First_book_program;

public class JosePH_2 {

	public static void main(String[] args) {
		System.out.println(joseph_1(8, 4, 3));
		System.out.println(joseph_2(8, 4, 3));
	}

	// 数组模拟
	static int joseph_1(int n, int m, int k) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int left = n, start = k - 2, count;
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
	static int joseph_2(int n, int m, int k) {
		DeNode head = new DeNode(1);
		DeNode p = head;
		for (int i = 1; i < n; i++) {
			p.next = new DeNode(i + 1);
			p = p.next;
		}
		p.next = head;

		while (k > 1) {
			k--;
			p = p.next;
		}

		int left = n, count;
		while (left > 0) {
			count = 0;
			while (count != m - 1) {
				count++;
				p = p.next;
			}
			left--;
			p.next = p.next.next;
		}
		return p.val;
	}
}
