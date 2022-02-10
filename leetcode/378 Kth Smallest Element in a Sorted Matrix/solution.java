class Solution {
    public int kthSmallest(int[][] matrix, int k) { // ������LeetCode240��ͬ����Z���Ͳ��ң�����ͬʱ���ö��ֲ���˼�룡����
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int notLargerThan = 0;
        while (low < high) {
            int mid = low + (high-low)/2;
            notLargerThan = zigZagSearch(matrix, mid);
            if (notLargerThan < k) { // case1����ΪnotLargerThan��¼��������Ԫ��ֵС�ڵ���mid��Ԫ�ظ�������������ֵΪmid��Ԫ�أ����ʵ��ü�¼С��k��ʱ����kС��ֵ��Ȼ����mid������
                low = mid+1;
            } else {
                high = mid; // case2��mid�����ǵ�kС������
            }
        }
        return low;
    }

    public int zigZagSearch(int[][]matrix, int mid) {
        int row = matrix.length-1; // Z���Ͳ���ʱ���½�Ϊ��㣡����
        int colum = 0;
        int count = 0;
        while (row >= 0 && colum <= matrix.length-1) { // Խ����˳���������ֵΪmid��Ԫ�ؿ����ж����Ҫȫ��ɨ�裡����
            if (matrix[row][colum] <= mid) { // ����ʱ����ǰԪ�ؼ����������Ϸ�Ԫ�ر�ȻС�ڵ���mid������
                colum++;
                count += row+1; // ע�⣺��¼����С�ڵ���mid�ĸ������������ϸ�С��mid������
            } else {
                row--;
            }
        }
        return count;
    }
}