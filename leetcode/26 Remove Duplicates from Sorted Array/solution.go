func removeDuplicates(nums []int) int { // ����ָ�룡����
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