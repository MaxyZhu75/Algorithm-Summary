func dominantIndex(nums []int) int {
    var n int = len(nums)
    maxNum1 := math.MinInt32 // Go语言math导入包，MinInt32此处初始化作负无穷使用！！！
    maxNum2 := math.MinInt32
    maxIndex := -1
    for i:=0; i<n; i++ { // 一次遍历更新nums中最大值与第二大的值以及最大值的下标！！！
        if nums[i] > maxNum1 { // case1：新的最大值！！！
            maxNum2 = maxNum1
            maxNum1 = nums[i]
            maxIndex = i
        } else if nums[i] > maxNum2 { // case2：新的第二大的值！！！
            maxNum2 = nums[i]
        }
    }

    if maxNum1 >= (2*maxNum2) {
        return maxIndex
    }
    return -1
}