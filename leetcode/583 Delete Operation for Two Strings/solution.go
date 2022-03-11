func minDistance(word1 string, word2 string) int { // 该题即最长公共子序列问题，请见LeetCode1143题！！！
    m, n := len(word1), len(word2)
    d := make([][]int, m+1)
    for i:=0; i<m+1; i++ {
        d[i] = make([]int, n+1)
    }

    for i, byte1 := range word1 {
        for j, byte2 := range word2 {
            if byte1 == byte2 {
                d[i+1][j+1] = d[i][j] + 1
            } else {
                d[i+1][j+1] = max(d[i+1][j], d[i][j+1])
            }
        }
    }

    return m+n-2*d[m][n] // 返回结果！！！
}

func max (a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}