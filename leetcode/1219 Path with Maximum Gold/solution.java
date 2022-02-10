class Solution { // 二维数组中的DFS回溯！！！
    int[][] grid;
    int m, n;
    int maxValue = 0;
    int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}}; // 要点一：可将结果变量等提前声明！！！

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length; // 类变量赋值！！！
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] != 0) {
                    dfsBackTrack(i, j, 0);
                }
            }
        }

        return maxValue;
    }

    public void dfsBackTrack(int row, int colum, int currentValue) { // 无返回值，直接对定义的结果变量操作！！！
        if (row < 0 || row >= m || colum < 0 || colum >= n) {
            return;
        }
        
        if (grid[row][colum] == 0) {
            return;
        }

        currentValue += grid[row][colum]; // 当前dfs递归结果！！！
        maxValue = Math.max(maxValue, currentValue); // 判断是否更新最终结果！！！

        int valueRecord = grid[row][colum]; // 要点二：DFS移动过程中包括三个重要处理步骤，且必须按顺序执行！！！
        grid[row][colum] = 0; // 处理一：标记已访问！！！

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            dfsBackTrack(nextRow, nextColum, currentValue); // 处理二：dfs往下递归！！！
        }

        grid[row][colum] = valueRecord; // 处理三：标记未访问！！！
    }
}