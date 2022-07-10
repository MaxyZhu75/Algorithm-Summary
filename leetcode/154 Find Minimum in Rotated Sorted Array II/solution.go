func findMin(nums []int) int { // 含重复元素「二分查找」！！！
    low, high := 0, len(nums)-1
    for low < high {
        mid := (high-low)/2 + low
        if nums[mid] < nums[high] {
            high = mid
        } else if nums[mid] == nums[high] { // 细节：单独考虑相等的情形，仅能排除high！！！
            high--
        } else {
            low = mid + 1
        }
    }
    return nums[low]
}