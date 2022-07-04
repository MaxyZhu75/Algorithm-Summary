func longestOnes(nums []int, k int) int { // 滑动窗口虫取法！！！
    zero := 0
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
    return right-left
}
