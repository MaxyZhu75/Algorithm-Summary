class TicTacToe {
	int n;
    int[][] rows; // 分别记录两个玩家n行n列以及两条对角线的情况！！！
    int[][] columns;
    int[][] diagonals;

    public TicTacToe(int n) {
        this.n = n;
		this.rows = new int[n][2];
        this.columns = new int[n][2];
        this.diagonals = new int[2][2];
    }

    public int move(int row, int col, int player) { // 仅关心当前落子所在的行，列，对角线！！！
        rows[row][player-1]++; // 行！！！
        if (rows[row][player-1] == n) return player;
       
   	    columns[col][player-1]++; // 列！！！
        if (columns[col][player-1] == n) return player;
        
		if (row == col) diagonals[0][player-1]++; // 正对角线！！！
        if (diagonals[0][player-1] == n) return player;
        
		if (row+col == n-1) diagonals[1][player-1]++; // 反对角线！！！
        if (diagonals[1][player-1] == n) return player;
        
		return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */