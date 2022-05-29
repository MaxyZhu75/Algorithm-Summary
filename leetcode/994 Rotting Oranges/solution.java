class Solution {
    public int orangesRotting(int[][] grid) { // 多源点BFS；类似LeetCode第1765题！！！
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int m = grid.length, n = grid[0].length;
        int minutes = -1, count = 0; // count统计当前新鲜橘子数量！！！
        
        Deque<Pair<Integer, Integer>> bfsQueue = new ArrayDeque<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    bfsQueue.addFirst(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count == 0) return 0; // 初始状态无新鲜橘子，直接返回！！！
        
        while (!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            minutes++;
            while(nextLevelNodes-- > 0) {
                Pair<Integer, Integer> neighbor = bfsQueue.pollFirst();
                int row = neighbor.getKey();
                int colum = neighbor.getValue();
                
                if (grid[row][colum] == 0) { // 过滤已访问的节点！！！
                    continue;
                } else if (grid[row][colum] == 1) {
                    count--;
                }
                
                if (count == 0) return minutes; // 注意：无新鲜橘子需要立即返回当前分钟数（BFS可能会进行下一轮空扫描，从而影响结果）！！！
                grid[row][colum] = 0; // 标记已访问！！！

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextColum = colum + direction[1];
                    if (nextRow < 0 || nextRow >= m || nextColum < 0 || nextColum >= n) {
                        continue;
                    } else {
                        bfsQueue.addLast(new Pair<>(nextRow, nextColum));
                    }
                }
            }
        }

        return -1;
    }
}