func minPathSum(grid [][]int) int {
    m, n := len(grid), len(grid[0]) // 行数与列数！！！
    
    d := make([][]int, m) // Go语言创建二维dp表的方式，需要记住！！！
    for i:=0; i<m; i++ {
        d[i] = make([]int, n)
    }

    d[0][0] = grid[0][0] // basecase！！！
    for i:=1; i<m; i++ { // 该题所创建dp表的大小与原数组相同时逻辑更清晰，但表的边界需要视作basecase，即先用两个循环为边界赋值！！！
        d[i][0] = d[i-1][0] + grid[i][0]
    }
    for j:=1; j<n; j++ {
        d[0][j] = d[0][j-1] + grid[0][j]
    }

    for i:=1; i<m; i++ { // dp方程填表即可！！！
        for j:=1; j<n; j++ {
            d[i][j] = min(d[i-1][j], d[i][j-1]) + grid[i][j] 
        }
    }

    return d[m-1][n-1]
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}