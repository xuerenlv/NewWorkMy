package leetcode_final;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Maximum_Product_of_Word_Lengths_318 {
    public static void main(String[] a){

        System.out.println("a");

        System.out.println(new Solution_Maximum_Product_of_Word_Lengths_318().sinature_str("abcd"));
        System.out.println(new Solution_Maximum_Product_of_Word_Lengths_318().sinature_str("ab"));
    }

}



// 感觉还可以优化,但是也没必要,一次就写出完美的出来
class Solution_Maximum_Product_of_Word_Lengths_318 {
    public int maxProduct(String[] words) {
        int[] signatures = new int[words.length];
        for(int i=0;i<words.length;i++){
            signatures[i] = sinature_str(words[i]);
        }

        int max_val = 0;
        for(int i=0;i<words.length-1;i++){
            for (int j=i+1;j<words.length;j++){
                if(words[i].length() * words[j].length() <= max_val) continue; //prunning
                if((signatures[i]&signatures[j])==0)
                    max_val = Math.max(max_val,words[i].length()*words[j].length());
            }
        }

        return max_val;
    }


    public int sinature_str(String s){
        int res = 0;
        for(int i=0;i<s.length();i++){
            res |= (1<<(s.charAt(i)-'a'));
        }
        return res;
    }
}