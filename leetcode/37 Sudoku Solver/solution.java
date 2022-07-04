class Solution {
    int n = 3;
    int N = n * n;
    char[][] board;
    int [][] rows = new int[N][N+1];
    int [][] columns = new int[N][N+1];
    int [][] boxes = new int[N][N+1];
    boolean sudokuSolved;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] != '.') {
					int digit = board[i][j] - '0';
					record(digit, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public void record(int digit, int i, int j) { // ��������������
        rows[i][digit]++;
        columns[j][digit]++;
        int index = (i/n)*n + j/n;
        boxes[index][digit]++;
        board[i][j] = (char)(digit + '0');
    }

    public void backtrack(int i, int j) {
        if (board[i][j] == '.') { // case1���Կո����dfs������������������
			for (int digit=1; digit<=9; digit++) {
				if (couldPlace(digit, i, j)) {
				    record(digit, i, j);
					placeNextCell(i, j);
					if (!sudokuSolved) {
                        removeNumber(digit, i, j);
                    }
				}
			}
        } else { // case2����ǰ�����������Դ�����һ�񣡣���
			placeNextCell(i, j);
		}
    }

    public boolean couldPlace(int digit, int i, int j) { // �ж���(i, j)������digit�Ƿ��������
        int index = (i/n)*n + j/n;
        return rows[i][digit] + columns[j][digit] + boxes[index][digit] == 0;
    }

    public void placeNextCell(int i, int j) { // ���Եݹ����д�����һ�񣡣���
        if (j == N-1 && i == N-1) {
            sudokuSolved = true;
            return;
        }
        if (j == N-1) {
			backtrack(i+1, 0);
		} else {
		    backtrack(i, j+1);   
		}
    }

    public void removeNumber(int digit, int i, int j) { // ����ɾ��(i, j)����digit������
        rows[i][digit]--;
        columns[j][digit]--;
        int index = (i/n)*n + j/n;
        boxes[index][digit]--;
        board[i][j] = '.';
    }
}