class Solution {
    public int[][] highestPeak(int[][] isWater) { // ��Դ��BFS���⣬��LeetCode��1091�����ƣ�����
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        int currentHeight = -1;

        Queue<Pair<Integer, Integer>> bfsQueue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if (isWater[i][j] == 1) { // Ҫ��һ����Դ��bfs��Ŀ����һ��Ҫ������ˮԴ�ӽ�ȥ������
                    bfsQueue.add(new Pair<>(i,j));
                }

                height[i][j] = -1; // Ҫ������ڽ��������������ǣ���δ���ʵ�Ϊ-1������
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

                if (height[row][colum] != -1) { // �ѱ��������������
                    continue;
                } else {
                    height[row][colum] = currentHeight; // ��ǰlevel�߶���ͬ������ 
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