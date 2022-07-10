func countBattleships(board [][]byte) int { // ���ף�һ��ɨ�裬ʹ��O(1)����ռ䣬���޸�board��ֵ������
    m, n := len(board), len(board[0])
    result := 0
    for i:=0; i<m; i++ {
        for j:=0; j<n; j++ {
            if board[i][j] == 'X' { // ö��ÿ��ս�������϶��㼴��ͳ��ս���ĸ���������X�����Ϸ��������ҪΪ�գ�����
                if i > 0 && board[i-1][j] != '.' {
                    continue
                }
                if j > 0 && board[i][j-1] != '.' {
                    continue
                }
                result++;
            }
        }
    }
    return result
}