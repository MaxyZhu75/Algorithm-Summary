class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { // �ɶ�ÿһ���ö��ֲ��ң����˴�ʹ�ø���Ч��Z���Ͳ��ҷ�������
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0; // Ҫ�㣺���Ҫ�ھ������Ͻǣ���ʱ��Ԫ��ȫ��С�ڣ��·�Ԫ��ȫ�����ڣ�target�������·�������
        int colum = n-1;
        while(row <= m-1 && colum >= 0) { // ÿ��ѭ��ִֻ��һ�����������ƻ����ƣ�����
            if (matrix[row][colum] == target) {
                return true;
            } else if (matrix[row][colum] < target) {
                row++; // ���ƣ�����
            } else {
                colum--; // ���ƣ�����
            }
        }
		
        return false;
    }
}