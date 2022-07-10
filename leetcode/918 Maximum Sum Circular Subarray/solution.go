func maxSubarraySumCircular(nums []int) int { // 动态规划空间优化版本！！！
    total := 0
    curMax, curMin, maxSum, minSum := 0, 0, math.MinInt32, math.MaxInt32
    for _, num := range nums {
        curMax = max(curMax+num, num) // 答案在「数组中间」，就是「最大子序和」！！！
        curMin = min(curMin+num, num) // 答案在「数组两边」，则是「total-最小的子序和」！！！
        maxSum = max(maxSum, curMax)
        minSum = min(minSum, curMin)
        total += num
    }
    if maxSum > 0 { // 细节:「最大子序和」小于0，则返回maxSum！！！
        return max(maxSum, total-minSum)
    } else {
        return maxSum
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}