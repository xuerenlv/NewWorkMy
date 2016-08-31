package leetcode_final;

/**
 * Created by Xuehj on 16/7/10.
 */
public class Power_of_Four_342 {
}


class Solution_Power_of_Four_342 {


    public boolean isPowerOfFour(int num) {

        if(num<=0)
            return false;

        int one_index = 0 ;
        int index_count = 0;
        while (num != 0){
            int te = num >> 1;
            if((num & 1) == 1){
                if(te != 0){
                    return false;
                }else{
                    break;
                }
            }
            num = te;
            index_count++;
        }


        return (index_count & 1)==1 ? false:true;
    }

}