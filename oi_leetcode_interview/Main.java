
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double res = 0.0;
		for (int i = 1; i <= n; i++) {
			res += (1.0 * n) / i;
		}
		System.out.print(String.format("%.4f", res));
	}
}