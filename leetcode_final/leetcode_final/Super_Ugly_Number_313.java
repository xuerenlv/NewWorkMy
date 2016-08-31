package leetcode_final;

/**
 * Created by Xuehj on 16/7/8.
 */
public class Super_Ugly_Number_313 {
    public static void main(String[] a){
        int[] arr = {2,7,13,19};
        System.out.println(new Solution_Super_Ugly_Number_313().nthSuperUglyNumber(11,arr));

    }
}




class Solution_Super_Ugly_Number_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] re = new int[n];
        re[0] = 1;


        int[] prim_index = new int[primes.length];
        int[] vals = new int[primes.length];
        for(int i=0;i<primes.length;i++)
            vals[i] = primes[i];

        for (int i = 1; i < n; i++) {
            int min_val = Integer.MAX_VALUE,min_index=0;

            // 这个地方可以使用堆
            for(int j=0;j<primes.length;j++){
                if(vals[j]<min_val){
                    min_val = vals[j];
                    min_index = j;
                }
            }
            re[i] = min_val;

            prim_index[min_index]++;
            vals[min_index] = re[prim_index[min_index]]*primes[min_index];

            // 重复元素
            if(re[i]==re[i-1])
                i--;
        }

        return re[n - 1];
    }
}