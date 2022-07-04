class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        int[][] rows = new int[N][N];
        int[][] colums = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int i=0; i<N; i++) { // 检查是否违反规则！！！
            for (int j=0; j<N; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int digit = board[i][j] - '1'; // 行！！！
                if (rows[i][digit] == 1) {
                    return false;
                }
                rows[i][digit] = 1;

                if (colums[j][digit] == 1) { // 列！！！
                    return false;
                }
                colums[j][digit] = 1;

                int index = (i/3)*3 + j/3; // 细节：九个盒子编号与索引的关系！！！
                if (boxes[index][digit] == 1) {
                    return false;
                }
                boxes[index][digit] = 1;
            }
        }
        return true;
    }
}