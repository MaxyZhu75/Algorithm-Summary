func searchRange(nums []int, target int) []int { // 两种模式的二分查找；左右边界需要不同判断条件！！！
    left := partition(nums, target, 0) // 查找第一个大于等于target的下标；即LeetCode第35题！！！
    right := partition(nums, target, 1) - 1 // 查找第一个大于target的下标，然后减去1！！！
    if left <= right && nums[left] == target && nums[right] == target { // 筛选有效结果！！！
        return []int{left, right}
    }
    return []int{-1, -1}
}

func partition(nums []int, target int, mode int) int {
    low, high, result := 0, len(nums)-1, len(nums) // 细节：查找失败时返回的是数组长度n！！！
    for low <= high {
        mid := (high-low)/2 + low
        if nums[mid] > target || (mode == 0 && nums[mid] >= target) { // 增加对模式的判断！！！
            result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return result
}