class Solution {
    public int getFood(char[][] grid) { // 常规BFS找最短路径问题！！！
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = grid.length;
        int n = grid[0].length;
        
        Deque<Pair<Integer, Integer>> bfsQueue = new ArrayDeque<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '*') { // 先找起点！！！
                    bfsQueue.addLast(new Pair<>(i, j));
                    break;
                }
            }
        }

        int steps = -1;
        while(!bfsQueue.isEmpty()) {
            steps++;
            int nextLevelNodes = bfsQueue.size();
            while(nextLevelNodes-- > 0) {
                Pair<Integer, Integer> neighbor = bfsQueue.pollFirst();
                int row = neighbor.getKey();
                int colum = neighbor.getValue();

                if (grid[row][colum] == 'X') { // 障碍物直接continue！！！
                    continue;
                } else if (grid[row][colum] == '#') { // 找到食物直接return！！！
                    return steps;
                }
                
                grid[row][colum] = 'X'; // 起点或空地标记已访问后BFS遍历！！！

                for(int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextColum = colum + direction[1];
                    if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n) {
                        bfsQueue.addLast(new Pair<>(nextRow, nextColum));
                    }
                }
            }
        }
        return -1;
    }
}