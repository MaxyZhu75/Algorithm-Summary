func missingElement(nums []int, k int) int {
    low, high := 0, len(nums)-1
    index := 0
    for low <= high { // 二分查找找到「最后一个左边缺失数字个数少于k的那个下标」！！！
        mid := (high-low)/2 + low
        if missCount(nums, mid) >= k {
            high = mid-1
        } else {
            index = mid
            low = mid+1
        }
    }
    return nums[index] + (k-missCount(nums, index)) // 确实数字即nums[index]后移 k-missCount(nums, index) ！！！
}

func missCount(nums []int, i int) int { // 总的空隙为nums[i]-nums[0]-1，可由索引为i推理数组中有i-1个数属于开区间(nums[0], nums[i])！！！
    return (nums[i]-nums[0]-1)-(i-1) // 左边缺失数字统计方法：(nums[i]-nums[0]-1)-(i-1)！！！
}