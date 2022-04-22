func subArrayRanges(nums []int) int64 { // 进阶解法为单调栈！！！
    n := len(nums)
    result := int64(0) // int64类型的初始化！！！
    for i:=0; i<n; i++ { // 考虑每个数作为子序列的开头！！！
        min, max := nums[i], nums[i]
        for j:=i+1; j<n; j++ { // 动态更新当前子序列最大值最小值，并计入结果！！！
            max = maxTwo(max, nums[j])
            min = minTwo(min, nums[j])        
            result += int64(max-min)
        }
    }
    return result
}

func maxTwo(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}

func minTwo(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}