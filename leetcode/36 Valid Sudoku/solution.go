func isValidSudoku(board [][]byte) bool {
    rows := [9][9]int{}
    colums := [9][9]int{}
    boxes := [9][9]int{}
    for i:=0; i<9; i++ { // 检查是否违反规则！！！
        for j:=0; j<9; j++ {
            if board[i][j] == '.' {
                continue
            }

            digit := int(board[i][j]-'1') // 行！！！
            if rows[i][digit] == 1 {
                return false
            }
            rows[i][digit] = 1

            if colums[j][digit] == 1 { // 列！！！
                return false
            }
            colums[j][digit] = 1
            
            index := (i/3)*3 + j/3 // 细节：九个盒子编号与索引的关系！！！
            if boxes[index][digit] == 1 {
                return false
            }
            boxes[index][digit] = 1
        }
    }
    return true
}