package leetcode_final;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Remove_Duplicate_Letters_316 {
	public static void main(String[] x) {
		System.out.println(new Solution_Remove_Duplicate_Letters_316().removeDuplicateLetters_other_people("bcabc"));
	}
}

class Solution_Remove_Duplicate_Letters_316 {
	String removeDuplicateLetters_other_people(String s) {
		int[] cnt = new int[26];
		int pos = 0; // the position for the smallest s[i]
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		
		// 找到第一个不可删除的最小 字典序 的字符
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos))
				pos = i;
			if (--cnt[s.charAt(i) - 'a'] == 0)
				break;
		}
		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	public String removeDuplicateLetters(String s) {
		if (s.length() <= 1)
			return s;

		int[] contains = new int[26];
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			if (contains[s.charAt(i) - 'a'] == 0) {
				contains[s.charAt(i) - 'a']++;
				sb.append(s.charAt(i));
			} else {
				if (sb.charAt(sb.length() - 1) == s.charAt(i)) {
					continue;
				} else {
					int occur = sb.indexOf(s.charAt(i) + "");
					System.out.println(occur + "----" + sb.toString() + "---" + s.charAt(i));
					if (s.charAt(i) < sb.charAt(occur + 1)) {
						sb.deleteCharAt(occur);
						sb.append(s.charAt(i));
						System.out.println("----" + sb.toString());
					} else {
						continue;
					}

				}

				// if(s.charAt(i)==res.charAt(res.length()-1)){
				// continue;
				// }else {
				// if(s.charAt(i)<res.charAt(contains[s.charAt(i)-'a']+1)){
				// res = res.substring(0,contains[s.charAt(i)-'a']) +
				// res.substring(contains[s.charAt(i)-'a']+1)+ s.charAt(i);
				// contains[s.charAt(i)-'a'] = res.length();
				// }else{
				// continue;
				// }
				// }
			}
		}

		return sb.toString();
	}
}