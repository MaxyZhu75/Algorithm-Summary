class Solution {
	int[][] grid;
	int m, n;
	int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 方向集合放在方法外面速度会快很多！！！
	
    public int maxAreaOfIsland(int[][] grid) { // 经典DFS题目，常用来解初始结点可达性问题；该题需要找出各节点最大的可达节点数量！！！
        this.grid = grid;
		m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i=0; i<m; i++) { // 遍历每个节点，由dfs探测可达性时记录可达节点的数量！！！
            for (int j=0; j<n; j++) {
                maxArea = Math.max(maxArea, dfs(i, j)); 
            }
        }
        return maxArea;
    }

    public int dfs(int row, int colum) { // 要点一：DFS需要栈实现，递归即是一种栈的运用，故单独写出一个dfs递归方法！！！        
        if (row < 0 || row >= m || colum < 0 || colum >= n) {
            return 0;
        }
        
        if (grid[row][colum] == 0) {
            return 0;
        }
        
        grid[row][colum] = 0; // 要点二：路过之处需要标记！！！
        
        int nodesNum = 1;
        for (int[] direction : directions) { // 要点三：递归计算不同方向的可达性；注意由于是递归，每个方向会走到尽头才会到下个循环处理另一个方向！！！
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            nodesNum += dfs(nextRow, nextColum); 
        }
        return nodesNum;
    }
}