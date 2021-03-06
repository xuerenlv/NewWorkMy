package leetcode_final_new_mac;

import java.util.Stack;

public class Longest_Absolute_File_Path_388 {

	public static void main(String[] args) {

		System.out.println(countLevel("\txhj"));
	}

	static int countLevel(String s) {
		String cur = s.replaceAll("\t", "");
		return s.length() - cur.length();
	}

}

class Solution_Longest_Absolute_File_Path_388 {
	public int lengthLongestPath(String input) {

		String[] tokens = input.split("\n");
		int result = 0;
		int curLen = 0;
		Stack<Integer> stack = new Stack<>();

		for (String s : tokens) {
			int level = countLevel(s);

			// if current directory/file depth is lower that the top
			// directory/file on the stack, pop from stack
			while (stack.size() > level) {
				curLen -= stack.pop();
			}

			// +1 here because a "/" needs to be counted following each diretory
			int len = s.replaceAll("\t", "").length() + 1;
			curLen += len;

			// if s contains ".", we have found a file!
			if (s.contains(".")) {
				result = curLen - 1 > result ? curLen - 1 : result;
				curLen -= len;
			} else {
				stack.add(len);
			}

		}
		return result;
	}

	private int countLevel(String s) {
		String cur = s.replaceAll("\t", "");
		return s.length() - cur.length();
	}
}