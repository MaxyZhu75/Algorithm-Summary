type TicTacToe struct {
    N int
    Rows [][]int // 分别记录两个玩家n行n列以及两条对角线的情况！！！
    Colums [][]int
    Diagonals [][]int
}

func Constructor(n int) TicTacToe {
    rows := make([][]int, n)
    colums:= make([][]int, n)
    diagonals:= make([][]int, n)
    
    for i:=0; i<n; i++ {
        rows[i] = make([]int, 2)
        colums[i] = make([]int, 2)
        diagonals[i] = make([]int, 2)
    }

    return TicTacToe {
        N: n,
        Rows: rows,
        Colums: colums,
        Diagonals: diagonals,
    }
}


func (this *TicTacToe) Move(row int, col int, player int) int { // 仅关心当前落子所在的行，列，对角线！！！
    this.Rows[row][player-1]++
    if this.Rows[row][player-1] == this.N { // 行！！！
        return player
    }

    this.Colums[col][player-1]++
    if this.Colums[col][player-1] == this.N { // 列！！！
        return player
    }

    if row == col {
        this.Diagonals[0][player-1]++
        if this.Diagonals[0][player-1] == this.N { // 正对角线！！！
            return player
        }
    }

    if row+col == this.N-1 {
        this.Diagonals[1][player-1]++
        if this.Diagonals[1][player-1] == this.N { // 反对角线！！！
            return player
        }
    }

    return 0
}


/**
 * Your TicTacToe object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Move(row,col,player);
 */