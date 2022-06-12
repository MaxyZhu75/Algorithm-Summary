class Solution {
    int[][] directions = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] grid;
    int n;

    public int largestIsland(int[][] grid) { // DFS + 计算连通块大小！！！
        this.grid = grid;
        this.n = grid.length;
        int island = 2; // 为各个岛屿编号！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 记录各个岛屿的面积大小！！！
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    hashRecord.put(island, dfs(i, j, island));
					island++;
				}
			}
		}
		
        int result = 0;
        for (int key : hashRecord.keySet()) {
			result = Math.max(result, hashRecord.get(key));	// result至少为单个岛屿的最大面积！！！
		}

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j] == 0) { // 每个0都是预备修改的对象，对于每个0用neighbors记录其周围四个方向接壤的岛屿！！！
                    Set<Integer> neighbors = new HashSet<>(); // 要点：必须使用Set对岛屿编号去重！！！
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + directions[k][0];
						int nextColum = j + directions[k][1];
						if (nextRow >= 0 && nextRow < n && nextColum >= 0 && nextColum < n) {
							if (grid[nextRow][nextColum] > 1) {
								neighbors.add(grid[nextRow][nextColum]);
							}	
						}
					}
                    int current = 1;
                    for (int neighbor : neighbors) {
						current += hashRecord.get(neighbor); // 将周围不同岛屿的面积相加即得修改当前0所能获得的最大连通块面积！！！
					}
                    result = Math.max(result, current);
                }

        return result;
    }

    public int dfs(int i, int j, int island) { // DFS计算岛屿面积！！！
        int count = 1;
        grid[i][j] = island; // 要点：相当于标记已访问，只有等于1时才是未访问的土地！！！
		for (int k = 0; k < 4; k++) {
            int nextRow = i + directions[k][0];
			int nextColum = j + directions[k][1];
			if (nextRow >= 0 && nextRow < n && nextColum >= 0 && nextColum < n) {
				if (grid[nextRow][nextColum] == 1) {
					grid[nextRow][nextColum] = island;
					count += dfs(nextRow, nextColum, island);
				}	
			}
        }

        return count;
    }
}