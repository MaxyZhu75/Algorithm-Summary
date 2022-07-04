class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = n-1, j = 0;
        while (i >= 0 && j < m) { //���������½ǡ�Ϊ��㣡����
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}