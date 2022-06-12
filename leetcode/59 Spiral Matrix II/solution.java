class Solution {
    public int[][] generateMatrix(int n) { // 按每层边界遍历；可参考LeetCode官方图解！！！
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1; // 上下左右四个边界！！！
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) { // 上边界！！！
                matrix[top][j] = num;
                num++;
            }
            for (int i = top+1; i <= bottom; i++) { // 右边界！！！
                matrix[i][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int j = right-1; j > left; j--) { // 下边界！！！
                    matrix[bottom][j] = num;
                    num++;
                }
                for (int i = bottom; i > top; i--) { // 左边界！！！
                    matrix[i][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}