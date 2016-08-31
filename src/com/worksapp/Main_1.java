/**
 * 
 */
package com.worksapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Xuehj
 *
 */
public class Main_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

		int[] container = new int[n * m];
		for (int i = 0; i < k; i++) {
			in.getLine();
			for (int j = 0; j < n; j++) {
				char[] one_line = in.getLine().toCharArray();
				for (int t = 0; t < m; t++) {
					if (one_line[t] == '1') {
						container[j * m + t]++;
					} else {
						container[j * m + t]--;
					}
				}
			}
		}

		int total = n * m;
		for (int j = 0; j < n; j++) {
			for (int t = 0; t < m; t++) {
				if (Math.abs(container[j * m + t]) == k)
					total--;
			}
		}

		int min = (int) Math.ceil((Math.log(k) / Math.log(2)));
		if (total >= min) {
			out.println(min);
		} else {
			out.println(-1);
		}

		out.close();
	}

	// read data
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String getLine() {
			String line = "";
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return line;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}
