func findMinFibonacciNumbers(k int) int { // 对小于等于k的斐波那契依次取最大贪心；最难点在于证明贪心策略正确性！！！
    fibonacciNumbers := []int{1, 1} // 用List方便动态添加元素！！！
    pre1, pre2 := 1, 1
    for (pre1 + pre2 <= k) { // 用while及辅助变量填写小于k的斐波那契数！！！
        current := pre1 + pre2
        fibonacciNumbers = append(fibonacciNumbers, current)
        pre2 = pre1
        pre1 = current
    }

    n := len(fibonacciNumbers)
    count := 0
    left := k
    for i:=n-1; i>=0 && k>0; i-- {
        greedyNum := fibonacciNumbers[i]
        if left - greedyNum >= 0 {
            left -= greedyNum
            count++
        } 
    }

    return count
}