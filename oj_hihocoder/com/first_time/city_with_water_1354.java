package com.first_time;

import java.util.Scanner;

public class city_with_water_1354 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt(),m=in.nextInt();
		int[] B = new int[n-1];
		int[] A = new int[m-1];
		
		for (int i = 0; i < n-1; i++) {
			B[i] = in.nextInt();
		}
		for (int i = 0; i < m-1; i++) {
			A[i] = in.nextInt();
		}
		
		
		boolean[][] grid = new boolean[n+1][m+1];
		int k = in.nextInt();
		for (int i = 0; i < k; i++) {
			int a = in.nextInt(),b=in.nextInt();
			grid[a][b] = true;
		}
		
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int s_x=in.nextInt(),s_y=in.nextInt(),e_x=in.nextInt(),e_y=in.nextInt();
			boolean[][] visited = new boolean[n+1][m+1];
			int[] result = {-1};
			
			
			solve_q(grid, visited, A, B, s_x, s_y, e_x, e_y, result,0,n,m);
			
			
			System.out.println(result[0]);
		}
		
		in.close();
	}

	static void solve_q(boolean[][] grid,boolean[][] visited,int[] A,int[] B,int s_x,int s_y,int e_x,int e_y,int[] result,int this_val,int n,int m){
		visited[s_x][s_y]=true;
		

	    if (s_x==e_x && s_y==e_y && (result[0]==-1 || this_val<result[0])) {
	        result[0]=this_val;
	        return;
	    }
	    
	    
	    int direct[][] = {{-1,0},{0,-1},{1,0},{0,1}};
	    
	    for (int i=0; i<4; i++) {
	        int new_x = s_x + direct[i][0];
	        int new_y = s_y + direct[i][1];
	        
	        if(!(1<=new_x && new_x<= n && 1<=new_y && new_y<=m))
	            continue;
	        if (visited[new_x][new_y] || grid[new_x][new_y]==true) {
	            continue;
	        }
	        
	        int now_val = 0;
	        if (new_x==s_x) {
	            if (new_y==s_y+1) {
	                now_val = A[s_y-1];
	            }else{
	                now_val = A[s_y-2];
	            }
	        }else{
	            if (new_x==s_x+1) {
	                now_val = B[s_x-1];
	            }else{
	                now_val = B[s_x-2];
	            }
	        }
	        
	        solve_q(grid, visited, A, B, new_x, new_y, e_x, e_y, result, this_val+now_val, n, m);
	        
	    }
		
		visited[s_x][s_y]=false;
	}
}
