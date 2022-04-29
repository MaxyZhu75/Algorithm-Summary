func maxSubArray(nums []int) int { // 动态规划空间优化版；另外官方解答有分治解法！！！
    current, max := 0, nums[0]
    for _, num := range nums { // 此处逻辑为：若current+num小于num，说明此前最大子串之和current为负数，则直接摒弃num之前的数使current等于num！！！
        current = maxInt(current+num, num) // d[i] = max(d[i?1]+nums[i], nums[i])！！！
        max = maxInt(max, current)
    }
    return max
}

func maxInt(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}