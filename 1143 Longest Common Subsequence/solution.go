func longestCommonSubsequence(text1 string, text2 string) int {
    m, n := len(text1), len(text2)
    d := make([][]int, m+1) // 创建dp表！！！
    for i:=0; i<m+1; i++ {
        d[i] = make([]int, n+1)
    }

    for i, byte1 := range text1 {
        for j, byte2 := range text2{
            if byte1 == byte2 { // 转移方程！！！
                d[i+1][j+1] = d[i][j] + 1 // case1：该位置两边字符串字母匹配！！！
            } else {
                d[i+1][j+1] = twoMax(d[i+1][j], d[i][j+1]) // case2：该位置两边字符串不匹配！！！
            }
        }
    }

    return d[m][n]
}

func twoMax(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}