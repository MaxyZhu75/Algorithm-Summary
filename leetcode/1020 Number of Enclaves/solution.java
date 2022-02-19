class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean visited[][];
    int grid[][]; // 只对visited做标记，grid未修改，放外面可减少内存占用！！！
    int m, n;

    public int numEnclaves(int[][] grid) { // 多源点DFS解决！！！
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        visited = new boolean[m][n]; // 边界的岛屿必然不是enclave，故我们可以从边界上的各个岛屿为源点开始向连通的内陆访问，然后对访问过的做visited标记！！！
        for (int i=0; i<m; i++) {
            dfs(i, 0);
            dfs(i, n-1);
        }

        for (int j=0; j<n; j++) {
            dfs(0, j);
            dfs(m-1, j);
        }

        int enclaves = 0; // 遍历，对没有被访问过内陆计数即可！！！
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }

    public void dfs(int row, int colum) {
        if (row < 0 || row >= m || colum < 0 || colum >=n) {
            return;
        }

        if (grid[row][colum] == 0) {
            return;
        }

        if (visited[row][colum]) {
            return;
        }

        visited[row][colum] = true; // 仅对visited标记！！！

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            dfs(nextRow, nextColum);
        }
    }
}