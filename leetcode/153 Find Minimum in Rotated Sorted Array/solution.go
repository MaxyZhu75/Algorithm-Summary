func findMin(nums []int) int { // 不含重复元素，直接常规「二分查找」！！！
    low, high := 0, len(nums)-1
    for low < high {
        mid := (high-low)/2 + low
        if nums[mid] <= nums[high] {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return nums[low]
}