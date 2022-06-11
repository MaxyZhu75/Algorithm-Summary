class Solution {
    public List<Integer> spiralOrder(int[][] matrix) { // 按每层边界遍历；可参考LeetCode官方图解！！！
        List<Integer> result = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1; // 上下左右四个边界！！！
        
	while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) { // 上边界！！！
                result.add(matrix[top][j]);
            }
            for (int i = top+1; i <= bottom; i++) { // 右边界！！！
                result.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int j = right-1; j > left; j--) { // 下边界！！！
                    result.add(matrix[bottom][j]);
                }
                for (int i = bottom; i > top; i--) { // 左边界！！！
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        
	return result;
    }
}
