func maxProfit(prices []int, fee int) int { // DP的状态转换问题，关键弄清楚几个状态及状态含义；与LeetCode309题类似！！！
    n := len(prices)
    d := make([]int, 2)
    d[0], d[1] = -prices[0], 0 // basecase！！！

    for i:=1; i<n; i++ { // 每次循环设置临时变量（因为要用到上一次存储的结果）！！！
        zero := max(d[0], d[1]-prices[i]) // 即 d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i])！！！
        one := max(d[0]+prices[i]-fee, d[1]) // 即 d[i][1] = Math.max(d[i-1][0]+prices[i]-fee, d[i-1][1])！！！
        d[0], d[1] = zero, one
    }
    return d[1] // 最后一天希望收益最大，手上股票肯定已丢出跑路，不会再买来烂在荷包里！！！
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}