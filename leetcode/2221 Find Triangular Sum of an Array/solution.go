func triangularSum(nums []int) int { // ±©Á¦½â·¨£¡£¡£¡
    for n:=len(nums); n>0; n-- {
        for i:=0; i<n-1; i++ {
            nums[i] = (nums[i] + nums[i+1]) % 10
        }
    }
    return nums[0]
}