package leetcode_final;

import java.util.List;

/**
 * Created by Xuehj on 16/7/12.
 */
public class Reverse_Vowels_of_a_String_345 {
    public static void main(String[] a){
        System.out.println(new Solution_Reverse_Vowels_of_a_String_345().reverseVowels("leetcode"));
        System.out.println();
    }
}


class Solution_Reverse_Vowels_of_a_String_345 {


        public String reverseVowels_other(String s) {
            if(s == null || s.length()==0) return s;
            String vowels = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int start = 0;
            int end = s.length()-1;
            while(start<end){

                while(start<end && !vowels.contains(chars[start]+"")){
                    start++;
                }

                while(start<end && !vowels.contains(chars[end]+"")){
                    end--;
                }

                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
            return new String(chars);
        }




    char vowels[] = {'a','o','e','i','u','v'};

    boolean containe_voel(char ch){
        for(int i=0;i<vowels.length;i++){
            if(Character.toLowerCase(ch)==vowels[i])
                return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        if(s.length()<=1)
            return s;
        int start = 0,end = s.length()-1;

        while (true){
            System.out.println(start+"--xx--"+end);
            while (!containe_voel(s.charAt(start)) && start<end)
                start++;
            while (!containe_voel(s.charAt(end)) && start<end)
                end--;

            System.out.println(start+"----"+end);
            if(start<end){
                if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                    s=s.substring(0,start)+s.charAt(end)+s.substring(start+1,end)+s.charAt(start)+s.substring(end+1);
                }

                start++;
                end--;
            }else{
                break;
            }

        }

        return s;
    }
}