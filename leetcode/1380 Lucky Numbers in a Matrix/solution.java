class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) { // ͨ����֤����֤��������������һ��������������
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] columMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);

        for (int i=0; i<m; i++) { // ������ά���飬�洢ÿ�е���Сֵ�Լ�ÿ�е����ֵ������
            for (int j=0; j<n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                columMax[j] = Math.max(columMax[j], matrix[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<m; i++) { // �ٴα�����ά���飬����ǰԪ���뵱ǰ����Сֵ����ǰ�����ֵ�Ƚϣ��������Ϊ������������
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == columMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}