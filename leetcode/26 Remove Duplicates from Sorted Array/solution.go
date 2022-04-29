func removeDuplicates(nums []int) int { // ¿ìÂıÖ¸Õë£¡£¡£¡
    slow, fast := 1, 1
    for fast < len(nums) {
        if nums[fast] != nums[fast-1] {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    nums = nums[:slow]
    return slow
}