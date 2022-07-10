class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] matrix;
	int[][] memory;
	int m, n;

    public int longestIncreasingPath(int[][] matrix) { // 常规方法超时，需要「记忆化DFS」！！！
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memory = new int[m][n]; // 已经计算过的单元格的结果存储到缓存矩阵中！！！
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        return result;
    }

    public int dfs(int i, int j) {
        if (memory[i][j] != 0) { // 已存在计算结果，直接返回！！！
            return memory[i][j];
        }
        memory[i][j]++;
        for (int[] direction : directions) {
            int nextRow = i + direction[0];
			int nextColum = j + direction[1];
            if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n && matrix[nextRow][nextColum] > matrix[i][j]) { // 邻居是更大的元素才跳！！！
                memory[i][j] = Math.max(memory[i][j], dfs(nextRow, nextColum) + 1); // 细节：比较当前计算结果，以及从邻居跳过来的计算结果！！！
            }
        }
        return memory[i][j];
    }
}