class Solution {
    public int countBattleships(char[][] board) { // 进阶：一次扫描，使用O(1)额外空间，不修改board的值！！！
        int m = board.length, n = board[0].length;
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') { // 枚举每个战舰的左上顶点即可统计战舰的个数，即「X」的上方及左侧需要为空！！！
                    if (i > 0 && board[i-1][j] != '.') {
                        continue;
                    }
                    if (j > 0 && board[i][j-1] != '.') {
                        continue;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}