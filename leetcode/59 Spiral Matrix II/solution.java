class Solution {
    public int[][] generateMatrix(int n) { // ��ÿ��߽�������ɲο�LeetCode�ٷ�ͼ�⣡����
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1; // ���������ĸ��߽磡����
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) { // �ϱ߽磡����
                matrix[top][j] = num;
                num++;
            }
            for (int i = top+1; i <= bottom; i++) { // �ұ߽磡����
                matrix[i][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int j = right-1; j > left; j--) { // �±߽磡����
                    matrix[bottom][j] = num;
                    num++;
                }
                for (int i = bottom; i > top; i--) { // ��߽磡����
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