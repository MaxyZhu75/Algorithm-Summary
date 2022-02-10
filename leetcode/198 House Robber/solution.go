func rob(nums []int) int {
    n := len(nums)
    if n == 1 {
        return nums[0]
    }
    if n == 2 {
        return max(nums[0], nums[1])
    }
    pre1, pre2 := max(nums[0], nums[1]), nums[0] // 由于d[i]只与i-1与i-2两个状态有关，可以空间优化！！！
    for i:=2; i<n; i++ {
        current := max(pre1, pre2+nums[i]) // 即dp方程 d[i] = max(d[i-1], d[i-2]+nums[i])！！！
        pre2 = pre1
        pre1 = current
    }
    return pre1
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}