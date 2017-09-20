package First_book_program;

public class Joseph_formal {

	public static void main(String[] args) {

		// System.out.println(joseph_1(6, 2));
		// System.out.println(joseph_1(12, 4));
		// System.out.println(joseph_1(8, 3));

		System.out.println(joseph_2(8, 4, 3));
	}

	static int joseph_1(int n, int m) {
		int s = 0;
		for (int i = 2; i <= n; i++)
			s = (s + m) % i;
		return s + 1;
	}

	static int joseph_2(int n, int m, int k) {
		int s = 0;
		for (int i = 2; i <= n; i++) {
			s = (s + m) % i;
		}
		return s + 1;
	}

}
