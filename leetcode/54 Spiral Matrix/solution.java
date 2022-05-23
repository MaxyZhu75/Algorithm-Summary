class Solution {
    public List<Integer> spiralOrder(int[][] matrix) { // 按每层边界遍历；可参考LeetCode官方图解！！！
        List<Integer> result = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1; // 上下左右四个边界！！！
        
		while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) { // 上边界！！！
                result.add(matrix[top][column]);
            }
            for (int row = top+1; row <= bottom; row++) { // 右边界！！！
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right-1; column > left; column--) { // 下边界！！！
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) { // 左边界！！！
                    result.add(matrix[row][left]);
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