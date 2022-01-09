func maxProfit(prices []int) int {
    var n int = len(prices) // len()的使用!!!
    if n==0 { 
        return 0
    }
    var currentMin int = prices[0] // 初始值为第一天股价!!!
    maxProfit := 0
    for i:=0; i<n; i++ {
        if prices[i] < currentMin {
            currentMin = prices[i] // if-else 结构即买与卖，且满足买和卖不能在同一天操作的条件!!!
        } else {
            maxProfit = Max(maxProfit, prices[i]-currentMin) // 整型的最大值函数手动写!!!
        }
    }
    return maxProfit
}

func Max(a int, b int) int {
    if a < b {
        return b
    } else {
        return a
    }
}