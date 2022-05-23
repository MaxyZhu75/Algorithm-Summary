class Solution {
    public List<Integer> spiralOrder(int[][] matrix) { // ��ÿ��߽�������ɲο�LeetCode�ٷ�ͼ�⣡����
        List<Integer> result = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1; // ���������ĸ��߽磡����
        
		while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) { // �ϱ߽磡����
                result.add(matrix[top][column]);
            }
            for (int row = top+1; row <= bottom; row++) { // �ұ߽磡����
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right-1; column > left; column--) { // �±߽磡����
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) { // ��߽磡����
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