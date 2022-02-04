class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { // 可对每一排用二分查找，但此处使用更高效的Z字型查找法！！！
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0; // 要点：起点要在矩阵右上角；此时左方元素全部小于，下方元素全部大于，target必在左下方！！！
        int colum = n-1;
        while(row <= m-1 && colum >= 0) { // 每次循环只执行一步操作，左移或下移！！！
            if (matrix[row][colum] == target) {
                return true;
            } else if (matrix[row][colum] < target) {
                row++; // 下移！！！
            } else {
                colum--; // 左移！！！
            }
        }
		
        return false;
    }
}