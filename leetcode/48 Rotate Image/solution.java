class Solution {
    public void rotate(int[][] matrix) { // 观察可知操作可拆解为两步！！！
        int n = matrix.length;
        for (int i=0; i<n/2; i++) { // Step1：水平上下翻转！！！
            for (int j=0; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        for (int i=0; i<n; i++) { // Step2：矩阵转置（按主对角线翻转）！！！
            for (int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}