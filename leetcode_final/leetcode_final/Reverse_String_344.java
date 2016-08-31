package leetcode_final;

/**
 * Created by Xuehj on 16/7/12.
 */
public class Reverse_String_344 {
}




class Solution_Reverse_String_344 {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}