
public class Is_Subsequence_392 {

	public static void main(String[] args) {
		System.out.println(new Solution_Is_Subsequence_392().isSubsequence("abc", "abc"));
		System.out.println(new Solution_Is_Subsequence_392().isSubsequence("axc", "ahbgdc"));
	}

}

class Solution_Is_Subsequence_392 {
	public boolean isSubsequence(String s, String t) {
		int s_index = 0, t_index = 0;
		if(s==null || s.length()==0)
			return true;
		if(t==null || t.length()==0)
			return false;
		
		
		while(t_index<t.length()){
			if(s.charAt(s_index)==t.charAt(t_index)){
				s_index++;
				if(s_index==s.length())
					return true;
			}
			
			t_index++;
		}
		
		return false;
	}
}