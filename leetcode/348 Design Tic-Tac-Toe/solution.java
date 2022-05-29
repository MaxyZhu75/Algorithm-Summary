class TicTacToe {
	int n;
    int[][] rows; // �ֱ��¼�������n��n���Լ������Խ��ߵ����������
    int[][] columns;
    int[][] diagonals;

    public TicTacToe(int n) {
        this.n = n;
		this.rows = new int[n][2];
        this.columns = new int[n][2];
        this.diagonals = new int[2][2];
    }

    public int move(int row, int col, int player) { // �����ĵ�ǰ�������ڵ��У��У��Խ��ߣ�����
        rows[row][player-1]++; // �У�����
        if (rows[row][player-1] == n) return player;
       
   	    columns[col][player-1]++; // �У�����
        if (columns[col][player-1] == n) return player;
        
		if (row == col) diagonals[0][player-1]++; // ���Խ��ߣ�����
        if (diagonals[0][player-1] == n) return player;
        
		if (row+col == n-1) diagonals[1][player-1]++; // ���Խ��ߣ�����
        if (diagonals[1][player-1] == n) return player;
        
		return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */