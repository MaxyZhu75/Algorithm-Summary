func maximalSquare(matrix [][]byte) int { // 动态规划！！！
    m, n, side := len(matrix), len(matrix[0]), 0
    d := make([][]int, m+1) // d[i][j]表示以(i, j)为右下角的「正方形最大边长」或「正方形的数目」！！！
    for i:=0; i<m; i++ {
        d[i] = make([]int, n+1)
    }
    for i:=0; i<m; i++ {
        for j:=0; j<n; j++ {
            if i == 0 || j ==0 { // 转移方程分三种情况！！！
                d[i][j] = int(matrix[i][j]-'0')
            } else if matrix[i][j] == '0' {
                d[i][j] = 0
            } else {
                d[i][j] = min(d[i-1][j], d[i][j-1], d[i-1][j-1]) + 1
            }
            side = max(side, d[i][j]) // 更新最大正方形边长！！！
        }
    }
    return side * side
}

func min(a int, b int, c int) int {
    if a <= b && a <= c {
        return a
    } else if b <= a && b <= c {
        return b
    } else {
        return c
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}