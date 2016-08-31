package leetcode_final_new_mac;

public class Ransom_Note_383 {

	public static void main(String[] args) {

	}

}

class Solution_Ransom_Note_383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() == 0)
			return true;
		if (magazine.length() < ransomNote.length())
			return false;

		int rem[] = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			rem[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (rem[ransomNote.charAt(i) - 'a'] == 0)
				return false;

			rem[ransomNote.charAt(i) - 'a']--;
		}

		return true;
	}
}