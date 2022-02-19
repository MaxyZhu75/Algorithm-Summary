func maxProfit(prices []int) int { // 同一天可以买卖；且交易次数无限制！！！
    n := len(prices)
    d := make([]int, 2)
    
    d[0] = -prices[0] // basecase！！！
    
    for i:=0; i<n; i++ {
        zero := max(d[0], d[1]-prices[i]) // 即 d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i])！！！
        one :=  max(d[0]+prices[i], d[1]) // 即 d[i][1] = Math.max(d[i-1][0]+prices[i], d[i-1][1])！！！
        d[0], d[1] = zero, one
    }

    return d[1]
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}