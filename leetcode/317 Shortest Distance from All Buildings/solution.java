public class Solution {
    public int shortestDistance(int[][] grid) { // 多源点BFS改版！！！
        final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m  = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n]; // 记录「空地」到其他building的总距离！！！
        int[][] paths = new int[m][n]; // 记录「空地」能够到达其他building的数量！！！
        int building = 0; // 统计building的总数！！！

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) { // 以每个building作为BFS源点！！！
                    building++;
                    Deque<Pair<Integer, Integer>> bfsQueue = new LinkedList<>();
                    bfsQueue.addLast(new Pair<>(i, j));
                    boolean[][] visited = new boolean[m][n]; // 每个源点各自BFS需要自己的已访问数组，故在循环内new！！！
                    int level = 0;
                    while (!bfsQueue.isEmpty()) {
                        level++;
						int size = bfsQueue.size();
                        while (size-- > 0) {
							Pair<Integer, Integer> current = bfsQueue.pollFirst();
							int row = current.getKey(), colum = current.getValue();
							for (int[] direction : directions) {
                                int nextRow = row + direction[0];
                                int nextColum = colum + direction[1];
                                if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n ) {
                                    if (grid[nextRow][nextColum] == 0 && !visited[nextRow][nextColum]) {
                                        distance[nextRow][nextColum] += level;  // 先判断是否为未访问空地，直接在此处对该待访问空地进行操作更简便（写for循环外的话要分类处理）！！！
                                        paths[nextRow][nextColum]++;
                                        visited[nextRow][nextColum] = true;
                                        bfsQueue.addLast(new Pair<>(nextRow, nextColum));
                                    }
								}
                            }
                        }
                    }
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0 && paths[i][j] == building) { // 遍历每块空地，选出能到达所有building里距离最短的！！！
                    result = Math.min(result, distance[i][j]);
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}