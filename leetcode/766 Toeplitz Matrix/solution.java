class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) { // 仅需将每一个元素和它左上角的元素相比对即可；进阶问题见三叶题解！！！
        int m = matrix.length, n = matrix[0].length;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}