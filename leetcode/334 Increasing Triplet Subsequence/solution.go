func increasingTriplet(nums []int) bool {
    var n int = len(nums)
    low := nums[0]  // 每一步由贪心更新值最小的low与值第二小mid！！！
    mid := math.MaxInt32 // Go语言math导入包，MaxInt32此处初始化作正无穷使用！！！
    for i:=1; i<n; i++ {
        if nums[i] > mid { // case1：递增序列出现，直接return！！！
            return true
        } else if nums[i] > low { // case2：更新mid！！！
            mid = nums[i]
        } else {
            low = nums[i] // case3：更新low！！！
        }
    }
    return false
}