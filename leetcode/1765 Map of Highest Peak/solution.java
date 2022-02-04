class Solution {
    public int[][] highestPeak(int[][] isWater) { // 多源点BFS问题，与LeetCode第1091题相似！！！
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        int currentHeight = -1;

        Queue<Pair<Integer, Integer>> bfsQueue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if (isWater[i][j] == 1) { // 要点一：多源点bfs题目，第一层要把所有水源加进去！！！
                    bfsQueue.add(new Pair<>(i,j));
                }

                height[i][j] = -1; // 要点二：在结果数组中自主标记，设未访问的为-1！！！
            }
        }

        while(!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            currentHeight++;

            while(nextLevelNodes > 0) {
                nextLevelNodes--;
                Pair<Integer, Integer> neighbor = bfsQueue.poll();
                int row = neighbor.getKey();
                int colum = neighbor.getValue();

                if (height[row][colum] != -1) { // 已标记则跳过！！！
                    continue;
                } else {
                    height[row][colum] = currentHeight; // 当前level高度相同！！！ 
                }

                for(int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextColum = colum + direction[1];
                    if (nextRow < 0 || nextRow >= m || nextColum < 0 || nextColum >= n) {
                        continue;
                    } else {
                        bfsQueue.add(new Pair<>(nextRow, nextColum));
                    }
                }

            }
        }

        return height;
    }
}