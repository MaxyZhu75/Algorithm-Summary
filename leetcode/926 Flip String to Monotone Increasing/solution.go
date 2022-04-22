func minFlipsMonoIncr(s string) int { // 动态规划空间优化版本！！！
    n := len(s)
    d := make([]int, 2)
    if s[0] == '0' { // d[0]表示末尾元素为时0的最小翻转次数！！！
        d[0] = 0
        d[1] = 1
    } else {         // d[1]表示末尾元素为1时的最小翻转次数！！！
        d[0] = 1
        d[1] = 0
    }

    for i:=1; i<n; i++ { // 由于dp转移方程只与前一状态有关，故可尝试优化！！！
        if s[i] == '0' {
            d[1] = min(d[0], d[1]) + 1
        } else {
            d[1] = min(d[0], d[1])
            d[0] = d[0] + 1
        }
    }

    return min(d[0], d[1])
}

func min(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}