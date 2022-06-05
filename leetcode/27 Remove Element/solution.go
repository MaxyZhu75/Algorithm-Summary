func removeElement(nums []int, val int) int { // 双指针！！！
    left, right := 0, len(nums)-1 // left左侧必是要保留的元素；right右侧必是删除元素！！！！！！
    for left <= right {
        if nums[left] == val {
            nums[left] = nums[right]
            right--
        } else {
            left++
        }
    }
    return left
}