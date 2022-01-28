func lengthOfLIS(nums []int) int {
    n := len(nums)
    result := 1
    d := make([]int, n+1)
    d[0], d[1] = 0, 1 // basecase！！！
    for i:=2; i<n+1; i++ { // 外层：将dp表每一格填完！！！
        d[i] = 1 // basecase全都置为1！！！
        for j:=1; j<i; j++ { // 内层：填某一格时遍历所有情况！！！
            if nums[i-1] > nums[i-1-j] {
                d[i] = max(d[i], d[i-j]+1)
            }
        }
        result = max(result, d[i]) // 更新当前dp表中最大长度子序列！！！
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