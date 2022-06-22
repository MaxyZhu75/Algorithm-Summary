func sortColors(nums []int)  { // 双指针解决「荷兰国旗问题」！！！
    n := len(nums)
    p0, p2 := 0, n-1 // 分别用来交换0和2！！！
    for i:=0; i<=p2; i++ {
        for i <= p2 && nums[i] == 2 { // while循环确保「位置i最终不是2」！！！
            nums[i], nums[p2] = nums[p2], nums[i]
            p2--
        }
        if nums[i] == 0 { // 此处if判别即可！！！
            nums[p0], nums[i] = nums[i], nums[p0]
            p0++
        }
    }
}