class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] matrix;
	int[][] memory;
	int m, n;

    public int longestIncreasingPath(int[][] matrix) { // ���淽����ʱ����Ҫ�����仯DFS��������
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memory = new int[m][n]; // �Ѿ�������ĵ�Ԫ��Ľ���洢����������У�����
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        return result;
    }

    public int dfs(int i, int j) {
        if (memory[i][j] != 0) { // �Ѵ��ڼ�������ֱ�ӷ��أ�����
            return memory[i][j];
        }
        memory[i][j]++;
        for (int[] direction : directions) {
            int nextRow = i + direction[0];
			int nextColum = j + direction[1];
            if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n && matrix[nextRow][nextColum] > matrix[i][j]) { // �ھ��Ǹ����Ԫ�ز���������
                memory[i][j] = Math.max(memory[i][j], dfs(nextRow, nextColum) + 1); // ϸ�ڣ��Ƚϵ�ǰ���������Լ����ھ��������ļ�����������
            }
        }
        return memory[i][j];
    }
}