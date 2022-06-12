func searchInsert(nums []int, target int) int { // 即查找第一个大于等于target的下标！！！
    n := len(nums)
    low, high, result := 0, n-1, n
    for low <= high {
        mid := (high-low)/2 + low // 细节：查找失败时（数组所有元素小于target）返回的是数组长度n！！！
        if nums[mid] >= target {
            result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return result
}