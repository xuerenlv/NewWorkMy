package leetcode_final;

import java.util.*;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Coin_Change_322 {
    public static void main(String[] a){

        int[] arr = {1,2,5};
        System.out.println(new Solution_Coin_Change_322().coinChange(arr,11));
    }
}




class Solution_Coin_Change_322 {


    public int coinChange_dp(int[] coins, int amount) {
        if(amount<1)
            return 0;

        int[] dp = new int[amount+1];
        int sum = 0;

        while(++sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }



    Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public int coinChange_other(int[] coins, int amount) {
        if(amount==0)
            return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount+1;
        for(int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount-coin);
                if(next >= 0)
                    curr = 1+next;
            }
            if(curr > 0)
                n = Math.min(n,curr);
        }
        int finalCount = (n==amount+1) ? -1 : n;
        amountDict.put(amount,finalCount);
        return finalCount;
    }



    // 超时,感觉也是肯定的
    public int coinChange(int[] coins, int amount) {
        if (amount==0)
            return 0;
        Arrays.sort(coins);
        int[] min_change = {Integer.MAX_VALUE};
        int[] now_change = {0};
        min_change_fun(coins,amount,now_change,min_change);
        return min_change[0]==Integer.MAX_VALUE?-1:min_change[0];
    }

    // amount > 0
    void min_change_fun(int[] coins_asc,int amount,int[] now_change,int[] min_change){

        for(int i=coins_asc.length-1;i>=0;i--){
            if(coins_asc[i]>amount)
                continue;
            if(coins_asc[i]==amount){
                now_change[0]++;
                if(min_change[0]>now_change[0])
                    min_change[0] = now_change[0];
                return;
            }
            now_change[0]++;
            min_change_fun(coins_asc,amount-coins_asc[i],now_change,min_change);
        }
    }
}
