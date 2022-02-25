func maximumDifference(nums []int) int { // 贪心思路同LeetCode121题股票买卖问题！！！
    currentMin, result := math.MaxInt32, -1
    for _, num := range nums {
        if num > currentMin {
            result = max(result, num-currentMin)
        } else {
            currentMin = num
        }
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}