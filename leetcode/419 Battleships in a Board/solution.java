class Solution {
    public int countBattleships(char[][] board) { // ���ף�һ��ɨ�裬ʹ��O(1)����ռ䣬���޸�board��ֵ������
        int m = board.length, n = board[0].length;
        int result = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') { // ö��ÿ��ս�������϶��㼴��ͳ��ս���ĸ���������X�����Ϸ��������ҪΪ�գ�����
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