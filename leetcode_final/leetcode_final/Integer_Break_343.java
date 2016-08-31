package leetcode_final;

/**
 * Created by Xuehj on 16/7/12.
 */
public class Integer_Break_343 {
}


class Solution_Integer_Break_343 {
    public int integerBreak(int n) {
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 1;
        for(int i=3;i<=n;i++){
            int val = 0;

            for(int j=1;j<=i/2+1;j++){
                val = Math.max(val,j*Math.max(res[i-j],i-j));
            }

            res[i]=val;
        }

        return res[n];
    }
}