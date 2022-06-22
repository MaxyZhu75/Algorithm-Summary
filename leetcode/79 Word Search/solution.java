class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	char[][] board;
	String word;
	boolean[][] visited;
	boolean result;

	public boolean exist(char[][] board, String word) { // DFS���ݣ�����
        this.board = board;
		this.word = word;
        int m = board.length, n = board[0].length;
		this.visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) { // �������п��ܵ�DFSԴ�㣡����
					dfsBackTracking(i, j, 0);
				}
            }
        }
        return result;
    }

    public void dfsBackTracking(int i, int j, int k) {
		if (k == word.length()-1) { // ������ڣ�����
            result = true;
        }
		int m = board.length, n = board[0].length;
        visited[i][j] = true; // ����ѷ��ʣ�����
        for (int[] direction : directions) { // �Ƚ���ɸѡ�����������Ž���ݹ飡����
            int nextRow = i+direction[0], nextColum = j+direction[1];
            if (nextRow >= 0 && nextRow < m && nextColum >= 0 && nextColum < n) {
                if (!visited[nextRow][nextColum]) {
                    if (k+1 < word.length() && board[nextRow][nextColum] == word.charAt(k+1)) {
						dfsBackTracking(nextRow, nextColum, k+1);
					}
                }
            }
        }
        visited[i][j] = false; // forѭ������ݣ�����
    }
}