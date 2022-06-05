func closestCost(baseCosts []int, toppingCosts []int, target int) int { // 0-1背包变形；见LeetCode第416题！！！
    M := 20000 // 确定准确地M较为繁琐，但该题M最大为20000可以确定，因为target与base属于[1, 10000]，定价超过20000则必不是最优解！！！
    d := make([]bool, M+1)
    for _, base := range baseCosts { // 必须加base！！！
        d[base] = true
    }
    for _, topping := range toppingCosts { // 同一个topping只加一次得到的定价！！！
        for j:=M; j>=1; j-- {
            if j > topping {
                d[j] = d[j] || d[j-topping]
            }
        }
    }
    for _, topping := range toppingCosts { // 同一个topping加两次能得到的定价！！
        for j:=M; j>=1; j-- {
            if j > topping {
                d[j] = d[j] || d[j-topping]
            }
        }
    }
    result, difference, minDiff := 0, 0, 20000
    for i:=1; i<=M; i++ { // 答案可能超过target，所以要用abs判断！！！
        difference = abs(i-target)
        if d[i] == true && difference < minDiff {
            result = i
            minDiff = difference
        }
    }
    return result
}

func abs(num int) int {
    if num < 0 {
        num = num * -1
    }
    return num
}