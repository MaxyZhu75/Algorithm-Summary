class Solution {
    public int orangesRotting(int[][] grid) { // ��Դ��BFS������LeetCode��1765�⣡����
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int m = grid.length, n = grid[0].length;
        int minutes = -1, count = 0; // countͳ�Ƶ�ǰ������������������
        
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

        if (count == 0) return 0; // ��ʼ״̬���������ӣ�ֱ�ӷ��أ�����
        
        while (!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            minutes++;
            while(nextLevelNodes-- > 0) {
                Pair<Integer, Integer> neighbor = bfsQueue.pollFirst();
                int row = neighbor.getKey();
                int colum = neighbor.getValue();
                
                if (grid[row][colum] == 0) { // �����ѷ��ʵĽڵ㣡����
                    continue;
                } else if (grid[row][colum] == 1) {
                    count--;
                }
                
                if (count == 0) return minutes; // ע�⣺������������Ҫ�������ص�ǰ��������BFS���ܻ������һ�ֿ�ɨ�裬�Ӷ�Ӱ������������
                grid[row][colum] = 0; // ����ѷ��ʣ�����

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