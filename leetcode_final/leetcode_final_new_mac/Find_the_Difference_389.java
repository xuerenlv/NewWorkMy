package leetcode_final_new_mac;

public class Find_the_Difference_389 {

	public static void main(String[] args) {
		System.out.println(new Solution_Find_the_Difference_389().findTheDifference("abc", "abcd"));
	}

}

class Solution_Find_the_Difference_389 {
	public char findTheDifference(String s, String t) {
		int res = 0;
		for(int i=0;i<s.length();i++){
			res ^= (s.charAt(i)-'a');
		}
		for(int i=0;i<t.length();i++){
			res ^= (t.charAt(i)-'a');
		}
		return (char)('a'+res);
	}
}