
public class Unique_Paths_II_63 {

	public static void main(String[] args) {

	}

}

class Solution_Unique_Paths_II_63 {
	// 压缩空间的 dp
	int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
			return 0;

		int m = obstacleGrid.length, n = obstacleGrid[0].length;

		int[][] view = new int[m][n];
		view[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				view[i][0] = 0;
			} else {
				view[i][0] = view[i - 1][0];
			}
		}

		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				view[0][i] = 0;
			} else {
				view[0][i] = view[0][i - 1];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					view[i][j] = 0;
				} else {
					view[i][j] = view[i - 1][j] + view[i][j - 1];
				}
			}
		}

		return view[m - 1][n - 1];
	}
}