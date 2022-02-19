func maxProfit(k int, prices []int) int { // 要点一：理解该题时始终记住，无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，因为这一操作带来的收益为零！！！
    n := len(prices)
    k = min(k, n/2) // k的最大值可以达到10^9, 而n天最多只能进行n/2笔交易！！！
    if k == 0 {
        return 0
    }

    d := make([]int, 2*k) // DP的状态转换问题，k次交易可定义2*k个状态；理解该题时请与LeetCode123题k=2呼应！！！
    for j:=0; j<2*k; j+=2 {
        d[j] = -prices[0] // 要点二：第1天所有持股状态basecase！！！
    }

    for i:=0; i<n; i++ {  // 每次循环设置临时变量（因为要用到上一次存储的结果）！！！
        temp := make([]int, 2*k)
        
        for j:=0; j<2*k; j++ {
            if j == 0 {
                temp[j] = max(d[0], -prices[i]) // 即 d[i][0] = Math.max(d[i-1][0], -prices[i])！！！
            } else if j % 2 == 0 {
                temp[j] = max(d[j-1]-prices[i], d[j]) // 即 d[i][j] = Math.max(d[i-1][j-1]-prices[i], d[i-1][j])！！！
            } else {
                temp[j] = max(d[j-1]+prices[i], d[j]) // 即 d[i][j] = Math.max(d[i-1][j-1]+prices[i], d[i-1][j])！！！
            }
        }
        
        for j:=0; j<2*k; j++ {
            d[j] = temp[j]
        }
    }

    return d[2*k-1] // 要点三：dp方程会将前次交易的结果转移到最后的空手状态中！！！
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}
