func getMaxLen(nums []int) int { // 分类动态规划！！！
    n := len(nums)
    positive, negative, result := 0, 0, 0
    if nums[0] > 0 {
        positive, result = 1, 1
    } else if nums[0] < 0 {
        negative = 1
    }

    for i:=1; i<n; i++ {
        if nums[i] > 0 { // case1：nums[i]为正！！！
            positive++
            if negative > 0 {
                negative++
            } else {
                negative = 0
            }
        } else if nums[i] < 0 { // case2：nums[i]为负！！！
            newNegative := positive + 1 // 要点：此处需要临时变量保存更新值！！！
            newPositive := 0
            if negative > 0 {
                newPositive = negative + 1
            } else {
                newPositive = 0
            }
            positive = newPositive
            negative = newNegative
        } else { // case3：nums[i]为0！！！
            negative, positive = 0, 0
        }
        result = max(result, positive)
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