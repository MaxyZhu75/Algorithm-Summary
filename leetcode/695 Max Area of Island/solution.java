class Solution {
	int[][] grid;
	int m, n;
	int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // ���򼯺Ϸ��ڷ��������ٶȻ��ܶ࣡����
	
    public int maxAreaOfIsland(int[][] grid) { // ����DFS��Ŀ�����������ʼ���ɴ������⣻������Ҫ�ҳ����ڵ����Ŀɴ�ڵ�����������
        this.grid = grid;
		m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i=0; i<m; i++) { // ����ÿ���ڵ㣬��dfs̽��ɴ���ʱ��¼�ɴ�ڵ������������
            for (int j=0; j<n; j++) {
                maxArea = Math.max(maxArea, dfs(i, j)); 
            }
        }
        return maxArea;
    }

    public int dfs(int row, int colum) { // Ҫ��һ��DFS��Ҫջʵ�֣��ݹ鼴��һ��ջ�����ã��ʵ���д��һ��dfs�ݹ鷽��������        
        if (row < 0 || row >= m || colum < 0 || colum >= n) {
            return 0;
        }
        
        if (grid[row][colum] == 0) {
            return 0;
        }
        
        grid[row][colum] = 0; // Ҫ�����·��֮����Ҫ��ǣ�����
        
        int nodesNum = 1;
        for (int[] direction : directions) { // Ҫ�������ݹ���㲻ͬ����Ŀɴ��ԣ�ע�������ǵݹ飬ÿ��������ߵ���ͷ�Żᵽ�¸�ѭ��������һ�����򣡣���
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            nodesNum += dfs(nextRow, nextColum); 
        }
        return nodesNum;
    }
}