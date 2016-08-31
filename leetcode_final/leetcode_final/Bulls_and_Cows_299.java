package leetcode_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Xuehj on 16/6/27.
 */
public class Bulls_and_Cows_299 {
    public static void main(String[] ac) {
        String a = "1123";
        String b = "0111";
        System.out.println(new Solution_Bulls_and_Cows_299().getHint(a,b));
    }
}


class Solution_Bulls_and_Cows_299 {

    String getHint_other(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint(String secret, String guess) {
        List<Integer> rem_equal = new ArrayList<>();
        HashMap<Character,Integer> rem_occur = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i))
                rem_equal.add(i);
            else
                rem_occur.put(secret.charAt(i),rem_occur.getOrDefault(secret.charAt(i),0)+1);
        }

        int occur = 0;
        for(int i =0;i<guess.length();i++){
            if(rem_equal.contains(i)){
                continue;
            }else if(rem_occur.containsKey(guess.charAt(i))){
                occur++;
                if(rem_occur.get(guess.charAt(i))==1){
                    rem_occur.remove(guess.charAt(i));
                }else {
                    rem_occur.put(guess.charAt(i), rem_occur.get(guess.charAt(i)) - 1);
                }
            }
        }

        return rem_equal.size()+"A"+occur+"B";
    }
}