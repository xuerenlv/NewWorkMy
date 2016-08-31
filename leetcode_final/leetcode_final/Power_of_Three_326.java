package leetcode_final;

/**
 * Created by Xuehj on 16/7/10.
 */
public class Power_of_Three_326 {
}


class Solution_Power_of_Three_326 {
    public boolean isPowerOfThree(int n) {

        if(n<=0)
            return false;

        while (n%3==0)
            n/=3;

        return n==1;
    }
}