package leetcode_final;

/**
 * Created by Xuehj on 16/7/15.
 */
public class Valid_Perfect_Square_367 {
    public static void main(String[] s){
        System.out.println(new Solution_Valid_Perfect_Square_367().isPerfectSquare(16));
    }
}



class Solution_Valid_Perfect_Square_367 {


    boolean isPerfectSquare_2(int num) {
        if (num < 1) return false;
        long t = num / 2 +1;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }

    public boolean isPerfectSquare(int num) {
        if(num<=0)
            return false;

        int start=0,end = num;
        while (start<=end){
            int mid = start+((end-start)>>1);
            int power_m = mid*mid;

            if(power_m==num)
                return true;
            if(power_m>num){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }


}