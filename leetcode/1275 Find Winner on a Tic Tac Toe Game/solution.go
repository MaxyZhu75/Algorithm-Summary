func tictactoe(moves [][]int) string { // 进阶版本见LeetCode348题！！！
    n := len(moves)
    rows := make([][]int, 3)
    colums := make([][]int, 3)
    diagonals := make([][]int, 3)
    for i:=0; i<3; i++ {
        rows[i] = make([]int, 2)
        colums[i] = make([]int, 2)
        diagonals[i] = make([]int, 2)
    }

    for i:=0; i<n; i++ {
        player := "player"
        if i % 2 == 0 {
            player = "A"
        } else {
            player = "B"
        }
        
        rows[moves[i][0]][i%2]++
        if rows[moves[i][0]][i%2] == 3 {
            return player
        }
        
        colums[moves[i][1]][i%2]++
        if colums[moves[i][1]][i%2] == 3 {
            return player
        }

        if moves[i][0] == moves[i][1] {
            diagonals[0][i%2]++
            if diagonals[0][i%2] == 3 {
                return player
            }
        }
        
        if moves[i][0] + moves[i][1] == 2 {
            diagonals[1][i%2]++
            if diagonals[1][i%2] == 3 {
                return player
            }
        }
    }

    if n < 9 {
        return "Pending"
    }

    return "Draw"
}