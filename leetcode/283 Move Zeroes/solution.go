func moveZeroes(nums []int)  { // 一次遍历考虑双指针或直接按照索引覆盖！！！
    n := len(nums)
    nonZeroIndex := 0
    for i:=0 ; i<n; i++ {
        if nums[i] != 0 {
            nums[nonZeroIndex] = nums[i]
            nonZeroIndex++
        }
    }
    for i:=nonZeroIndex; i<n; i++ {
        nums[i] = 0
    }
}