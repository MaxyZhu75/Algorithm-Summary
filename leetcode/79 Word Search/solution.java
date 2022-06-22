class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	char[][] board;
	String word;
	boolean[][] visited;
	boolean result;

	public boolean exist(char[][] board, String word) { // DFS回溯！！！
        this.board = board;
		this.word = word;
        int m = board.length, n = board[0].length;
		this.visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) { // 查找所有可能的DFS源点！！！
					dfsBackTracking(i, j, 0);
				}
            }
        }
        return result;
    }

    public void dfsBackTracking(int i, int j, int k) {
		if (k == word.length()-1) { // 到达出口！！！
            result = true;
        }
		int m = board.length, n = board[0].length;
        visited[i][j] = true; // 标记已访问！！！
        for (int[] direction : directions) { // 先进行筛选，符合条件才进入递归！！！
            int nextRow = i+direction[0], nextColum = j+direction[1];
            if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n) {
                if (!visited[nextRow][nextColum]) {
                    if (k+1 < word.length() && board[nextRow][nextColum] == word.charAt(k+1)) {
						dfsBackTracking(nextRow, nextColum, k+1);
					}
                }
            }
        }
        visited[i][j] = false; // for循环外回溯！！！
    }
}