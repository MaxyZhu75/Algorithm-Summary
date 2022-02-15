func maxProfit(prices []int) int { // 要点一：理解该题时始终记住，无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，因为这一操作带来的收益为零！！！
    d := make([]int, 4) // DP的状态转换问题，关键弄清楚几个状态及状态含义；与LeetCode309题类似！！！
    d[0], d[1], d[2], d[3] = -prices[0], 0, -prices[0], 0 // basecase！！！

    for i:=1; i<len(prices); i++ { // 每次循环设置临时变量（因为要用到上一次存储的结果）！！！
        zero := max(d[0], -prices[i]) // d[i][0] = Math.max(d[i-1][0], -prices[i])！！！
        one := max(d[0]+prices[i], d[1]) // d[i][1] = Math.max(d[i-1][0]+prices[i], d[i-1][1])！！！
        two := max(d[1]-prices[i], d[2]) // d[i][2] = Math.max(d[i-1][1]-prices[i], d[i-1][2])！！！
        tri := max(d[2]+prices[i], d[3]) // d[i][3] = Math.max(d[i-1][2]+prices[i], d[i-1][3])！！！
        d[0], d[1], d[2], d[3] = zero, one, two, tri
    }

    return d[3]; // 要点二：由于不需要考虑在同一天买入并且卖出的限制，即使状态1收益最大，dp方程也会将第一次交易的结果转移到状态3中！！！
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}