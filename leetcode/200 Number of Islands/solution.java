class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;

        Deque<Pair<Integer, Integer>> bfsQueue = new ArrayDeque<>(); // Dequeʵ��BFS���У�����
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') { // ����Ѱ�ҷ���������BFSԴ�㣡����
                    island++;
                    bfsQueue.addLast(new Pair<>(i,j));
                    while (!bfsQueue.isEmpty()) {
                        int nodeNum = bfsQueue.size();
                        while (nodeNum-- > 0) {
                            Pair<Integer, Integer> currentNode = bfsQueue.pollFirst();
                            int row = currentNode.getKey();
                            int colum = currentNode.getValue();
                            
                            if (grid[row][colum] == '0') { // ��Ϊ0��ֱ��continue���أ�����
                                continue;
                            }
                            
                            grid[row][colum] = '0'; // ��Ϊ1�����BFS��ǣ�����

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
                }
            }
        }
    return island;
    }
}