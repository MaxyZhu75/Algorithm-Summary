func maxProfit(prices []int) int { // DP的状态转换问题，关键弄清楚几个状态及状态含义！！！
    d := make([]int, 3)

    d[0], d[1], d[2] = -prices[0], 0, 0 // basecase！！！
    for i:=1 ; i<len(prices); i++ { // 每次循环设置临时变量（因为要用到上一次存储的结果）！！！
        zero := max(d[0], d[1]-prices[i]) // 即 d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i])！！！
        one := max(d[1], d[2]) // 即 d[i][1] = Math.max(d[i-1][1], d[i-1][2])！！！
        two := d[0] + prices[i] // 即 d[i][2] = d[i-1][0] + prices[i]！！！
        d[0], d[1], d[2] = zero, one, two
    }

    return max(d[1], d[2]) // 最后一天希望收益最大，手上股票肯定已丢出跑路，不会烂在荷包里！！！
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}