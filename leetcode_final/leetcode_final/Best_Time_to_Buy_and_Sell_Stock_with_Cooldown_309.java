package leetcode_final;

/**
 * Created by Xuehj on 16/7/2.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    public static void main(String[] a){
        int[] pr = {1, 2, 4};
        System.out.println(new Solution_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309().maxProfit(pr));
    }
}


class Solution_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    public int maxProfit(int[] prices) {
        return maxPro(prices,0,prices.length-1);
    }

    private int maxPro(int[] prices,int start,int end) {
        if (start >= end)
            return 0;
        if (start + 1 == end)
            return Math.max(0, prices[end] - prices[start]);


        return Math.max(Math.max(prices[start+1]-prices[start],0)+maxPro(prices,start+2,end),
                        Math.max(maxPro(prices,start+1,end),
                                Math.max(0,prices[start+2]-prices[start])+maxPro(prices,start+3,end)));

    }
}