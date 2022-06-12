public class Solution {
    public int shortestDistance(int[][] grid) { // ��Դ��BFS�İ棡����
        final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m  = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n]; // ��¼���յء�������building���ܾ��룡����
        int[][] paths = new int[m][n]; // ��¼���յء��ܹ���������building������������
        int building = 0; // ͳ��building������������

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) { // ��ÿ��building��ΪBFSԴ�㣡����
                    building++;
                    Deque<Pair<Integer, Integer>> bfsQueue = new LinkedList<>();
                    bfsQueue.addLast(new Pair<>(i, j));
                    boolean[][] visited = new boolean[m][n]; // ÿ��Դ�����BFS��Ҫ�Լ����ѷ������飬����ѭ����new������
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
                                        distance[nextRow][nextColum] += level;  // ���ж��Ƿ�Ϊδ���ʿյأ�ֱ���ڴ˴��Ըô����ʿյؽ��в�������㣨дforѭ����Ļ�Ҫ���ദ��������
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
                if (grid[i][j] == 0 && paths[i][j] == building) { // ����ÿ��յأ�ѡ���ܵ�������building�������̵ģ�����
                    result = Math.min(result, distance[i][j]);
                }
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}