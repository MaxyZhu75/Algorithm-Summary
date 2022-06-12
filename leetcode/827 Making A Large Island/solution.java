class Solution {
    int[][] directions = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] grid;
    int n;

    public int largestIsland(int[][] grid) { // DFS + ������ͨ���С������
        this.grid = grid;
        this.n = grid.length;
        int island = 2; // Ϊ���������ţ�����
        Map<Integer, Integer> hashRecord = new HashMap<>(); // ��¼��������������С������
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
			result = Math.max(result, hashRecord.get(key));	// result����Ϊ���������������������
		}

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j] == 0) { // ÿ��0����Ԥ���޸ĵĶ��󣬶���ÿ��0��neighbors��¼����Χ�ĸ���������ĵ��죡����
                    Set<Integer> neighbors = new HashSet<>(); // Ҫ�㣺����ʹ��Set�Ե�����ȥ�أ�����
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
						current += hashRecord.get(neighbor); // ����Χ��ͬ����������Ӽ����޸ĵ�ǰ0���ܻ�õ������ͨ�����������
					}
                    result = Math.max(result, current);
                }

        return result;
    }

    public int dfs(int i, int j, int island) { // DFS���㵺�����������
        int count = 1;
        grid[i][j] = island; // Ҫ�㣺�൱�ڱ���ѷ��ʣ�ֻ�е���1ʱ����δ���ʵ����أ�����
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