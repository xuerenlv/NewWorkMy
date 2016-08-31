package leetcode_final;

/**
 * Created by Xuehj on 16/7/10.
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {
    public static void main(String[] a){
        int[][] ma = {{9,9,4}, {6,6,8}, {2,1,1}};

        System.out.println(new Solution_Longest_Increasing_Path_in_a_Matrix_329().longestIncreasingPath(ma));
    }
}


class Solution_Longest_Increasing_Path_in_a_Matrix_329 {

    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath_others(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }




    // TLE
    public int longestIncreasingPath(int[][] matrix) {
        int[] l_paths = new int[1];
        if(matrix.length==0)
            return l_paths[0];
        int hang = matrix.length,lie = matrix[0].length;

        boolean[][] visited = new boolean[hang][lie];

        for(int i=0;i<hang;i++){
            for(int j=0;j<lie;j++){
                longestIncreasingPath_from(matrix,i,j,hang,lie,visited,1,l_paths);
            }
        }

        return l_paths[0];
    }

    void longestIncreasingPath_from(int[][] matrix,int s_h,int s_l,int hang,int lie,boolean[][] visited,int l_path,int[] l_paths){
        if(l_path>l_paths[0])
            l_paths[0] = l_path;
        visited[s_h][s_l]=true;

        if(s_h>0 && !visited[s_h-1][s_l] && matrix[s_h-1][s_l]>matrix[s_h][s_l])
            longestIncreasingPath_from(matrix,s_h-1,s_l,hang,lie,visited,l_path+1,l_paths);
        if(s_l>0 && !visited[s_h][s_l-1] && matrix[s_h][s_l-1]>matrix[s_h][s_l])
            longestIncreasingPath_from(matrix,s_h,s_l-1,hang,lie,visited,l_path+1,l_paths);

        if(s_h<hang-1 && !visited[s_h+1][s_l] && matrix[s_h+1][s_l]>matrix[s_h][s_l])
            longestIncreasingPath_from(matrix,s_h+1,s_l,hang,lie,visited,l_path+1,l_paths);
        if(s_l<lie-1 && !visited[s_h][s_l+1] && matrix[s_h][s_l+1]>matrix[s_h][s_l])
            longestIncreasingPath_from(matrix,s_h,s_l+1,hang,lie,visited,l_path+1,l_paths);

        visited[s_h][s_l]=false;
    }
}