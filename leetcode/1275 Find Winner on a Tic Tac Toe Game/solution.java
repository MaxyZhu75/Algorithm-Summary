class Solution {
    public String tictactoe(int[][] moves) { // 进阶版本见LeetCode348题！！！
        int n = moves.length;
        int[][] rows = new int[3][2];
        int[][] colums = new int[3][2];
        int[][] diagonals = new int[2][2];
        
        for (int i=0; i<n; i++) {
            String player = (i % 2 == 0) ? "A" : "B";
            rows[moves[i][0]][(i%2)]++;
            if (rows[moves[i][0]][(i%2)] == 3) return player;
            
            colums[moves[i][1]][(i%2)]++;
            if (colums[moves[i][1]][(i%2)] == 3) return player;

            if (moves[i][0] == moves[i][1]) diagonals[0][(i%2)]++;
            if (diagonals[0][(i%2)] == 3) return player;

            if (moves[i][0] + moves[i][1] == 2) diagonals[1][(i%2)]++;
            if (diagonals[1][(i%2)] == 3) return player;
        }
        
        return (n < 9) ? "Pending" : "Draw";
    }
}