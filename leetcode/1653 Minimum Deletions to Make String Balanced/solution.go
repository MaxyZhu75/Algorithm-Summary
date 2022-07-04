func minimumDeletions(s string) int { // 同LeetCode第926题！！！
    n := len(s)
    d := [2]int{}
    if s[0] == 'a' {
        d[0], d[1] = 0, 1 // d[0]表示末尾元素为时a的最小翻转次数！！！
    } else {
        d[0], d[1] = 1, 0 // d[1]表示末尾元素为b时的最小翻转次数！！！
    }
    for i:=1; i<n; i++ { // 由于dp转移方程只与前一状态有关，故可尝试优化！！！
        if s[i] == 'a' {
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