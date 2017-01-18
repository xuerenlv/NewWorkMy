package com.binary_search_question;

public class Poor_Pigs_458 {

	public static void main(String[] args) {
		System.out.println(new Solution_Poor_Pigs_458().poorPigs(1, 1, 1));
	}

}

class Solution_Poor_Pigs_458 {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if (buckets<0 || minutesToTest<minutesToDie)
			return -1;
		if (buckets<=1)
			return 0;
		
		int left = 1, right = buckets;
		while(left<right){
			int mid = (left+right)>>1;
			if(isOk(buckets, minutesToDie, minutesToTest, mid)){
				right = mid;
			}else {
				left = mid==left?mid+1:mid;
			}
		}
		
		return left;
	}
	
	
	private boolean isOk(int buckets, int minutesToDie, int minutesToTest,int pigs) {
		return (int)Math.pow((minutesToTest/minutesToDie + 1),pigs) >= buckets;
	}
	
	
	
}