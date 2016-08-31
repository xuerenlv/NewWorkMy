package leetcode_final;

import java.util.Map;

/**
 * Created by Xuehj on 16/6/14.
 */
public class Nim_Game_292 {
    public static void main(String[] a){
        Solution_Nim_Game_292 so = new Solution_Nim_Game_292();
        System.out.println(so.canWinNim_tle(41));
        System.out.println(so.canWinNim(41));
    }
}


class Solution_Nim_Game_292 {

    public boolean canWinNim(int n) {
        return  (n%4)!=0;
    }

    public boolean canWinNim_chaoshi(int n) {
        if(n>=1 && n<=3)
            return true;

        boolean pre_1=true,pre_2=true,pre_3=true,pre_now=false;

        for(int i=4;i<=n;i++){
            pre_now = !pre_1 || !pre_2 || !pre_3;
            pre_1=pre_2;
            pre_2=pre_3;
            pre_3=pre_now;
        }

        return  pre_now;
    }

    // 第二个版本 内存超出
    public boolean canWinNim_outofmem(int n) {
        if(n>=1 && n<=3)
            return true;

        boolean[] re = new boolean[n+1];
        re[1]=true;
        re[2]=true;
        re[3]=true;

        for(int i=4;i<=n;i++){
            re[i]=!re[i-1]||!re[i-2]||!re[i-3];
        }

        return  re[n];
    }

    // 第一个版本 超时
    public boolean canWinNim_tle(int n) {
        if(n==0)
            return false;
        if(n>=1 && n<=3)
            return true;
        return !canWinNim(n-1)||!canWinNim(n-2)||!canWinNim(n-3);
    }
}
