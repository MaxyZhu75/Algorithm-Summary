func lengthOfLIS(nums []int) int {
    n := len(nums)
    result := 1
    d := make([]int, n+1) // d[i]代表数组以nums[i-1]结尾的最长上升子序列！！！
    d[0], d[1] = 0, 1
    for i:=2; i<n+1; i++ {
        d[i] = 1 // 计数至少包含元素本身！！！
        for j:=1; j<i; j++ { // 以nums[i-1]为结尾，往左找！！
            if nums[i-1] > nums[i-1-j] {
                d[i] = max(d[i], d[i-j]+1)！ // 细节：对比当前结果与从nums[i-1-j]跳转过来的结果！！！
            }
        }
        result = max(result, d[i])
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
