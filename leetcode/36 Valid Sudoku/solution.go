func isValidSudoku(board [][]byte) bool {
    rows := [9][9]int{}
    colums := [9][9]int{}
    boxes := [9][9]int{}
    for i:=0; i<9; i++ { // ����Ƿ�Υ�����򣡣���
        for j:=0; j<9; j++ {
            if board[i][j] == '.' {
                continue
            }

            digit := int(board[i][j]-'1') // �У�����
            if rows[i][digit] == 1 {
                return false
            }
            rows[i][digit] = 1

            if colums[j][digit] == 1 { // �У�����
                return false
            }
            colums[j][digit] = 1
            
            index := (i/3)*3 + j/3 // ϸ�ڣ��Ÿ����ӱ���������Ĺ�ϵ������
            if boxes[index][digit] == 1 {
                return false
            }
            boxes[index][digit] = 1
        }
    }
    return true
}