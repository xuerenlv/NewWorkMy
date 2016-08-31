package leetcode_final;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Range_Sum_Query_2D_Immutable_304 {
    public static void main(String[] a){
        int[][] ma = {{3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};

        NumMatrix_Range_Sum_Query_2D_Immutable_304 num_ma = new NumMatrix_Range_Sum_Query_2D_Immutable_304(ma);
        System.out.println(num_ma.sumRegion(2, 1, 4, 3));
        System.out.println(num_ma.sumRegion(1, 1, 2, 2));
        System.out.println(num_ma.sumRegion(1, 2, 2, 4));
    }
}


class NumMatrix_Range_Sum_Query_2D_Immutable_304 {
    int[][] sum_matrix;

    public NumMatrix_Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
        if (matrix.length==0) {
            sum_matrix = new int[1][1];
            return;
        }
        sum_matrix = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum_matrix[i+1][j+1] = matrix[i][j]+sum_matrix[i][j+1]+sum_matrix[i+1][j] - sum_matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum_matrix[row2+1][col2+1]   + sum_matrix[row1][col1]-sum_matrix[row1][col2+1]-sum_matrix[row2+1][col1];
    }
}
