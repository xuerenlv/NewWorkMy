package leetcode_final;

import java.util.Arrays;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Bulb_Switcher_319 {
    public static void main(String[] a){
        System.out.println(new Solution_Bulb_Switcher_319().bulbSwitch(3));
    }
}


class Solution_Bulb_Switcher_319 {

    public int bulbSwitch_other(int n) {
        return (int)Math.sqrt(n);
    }

    // 这样做 超时
    public int bulbSwitch(int n) {
        if(n<=0)
            return 0;

        boolean[] buld = new boolean[n];
        for(int i=2;i<=n;i++){
            int k = 1;
            while (k*i<=n) {
                buld[k * i-1] = !buld[k * i-1];
                k++;
            }
        }

        int num =0;
        for(int i=0;i<n;i++)
            if(!buld[i])
                num++;

//        System.out.println(Arrays.toString(buld));

        return num;
    }


}
