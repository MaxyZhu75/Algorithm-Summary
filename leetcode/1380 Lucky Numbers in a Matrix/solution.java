class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) { // 通过反证法可证明该题最多仅存在一个幸运数！！！
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] columMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);

        for (int i=0; i<m; i++) { // 遍历二维数组，存储每行的最小值以及每列的最大值！！！
            for (int j=0; j<n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                columMax[j] = Math.max(columMax[j], matrix[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<m; i++) { // 再次遍历二维数组，将当前元素与当前行最小值及当前列最大值比较，皆相等则为幸运数！！！
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == columMax[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}