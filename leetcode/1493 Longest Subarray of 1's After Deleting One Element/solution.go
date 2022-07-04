func longestSubarray(nums []int) int { // 滑动窗口虫取法！！！
    k, zero := 1, 0
    left, right := 0, 0
    for right < len(nums) {
        if nums[right] == 0 {
            zero++
        }
        if zero > k {
            if (nums[left] == 0) {
                zero--
            }
            left++
        }
        right++
    }
    return right-left-1
}