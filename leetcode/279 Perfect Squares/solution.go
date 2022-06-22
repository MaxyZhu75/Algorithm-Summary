func numSquares(n int) int { // 动态规划（类似找零钱问题）！！！
    d := make([]int, n+1)
    for i:=1; i<=n; i++ { // d[i]表示最少需要多少个数的平方来表示整数i！！！
        minPre := math.MaxInt32
        for j:=1; j*j <= i; j++ {
            minPre = min(minPre, d[i - j*j])
        }
        d[i] = minPre + 1 // 转移方程：d[i] = min{d[i-j^2]}+1 ！！！
    }
    return d[n]
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}