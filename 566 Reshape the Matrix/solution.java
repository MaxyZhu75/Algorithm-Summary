class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int count = 0; // ��¼�Ѵ����Ԫ�ظ���������
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int flattenRow = count / n; // ����ѧϰ�е�flatten�������ɼ�ס�ñ任������
                int flattenColum = count % n;
                result[i][j] = mat[flattenRow][flattenColum];
                count++;
            }
        }

        return result;
    }
}