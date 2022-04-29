func nextPermutation(nums []int) { // 要求原地操作；解法正确性证明见LeetCode官方解答！！
    lastMini := len(nums)-2
    for lastMini >= 0 && nums[lastMini] >= nums[lastMini+1] { // 步骤一：寻找最靠后的极小值；这意味着此时该极小值后方元素必然降序排列！！！
        lastMini--
    }
    if lastMini >= 0 {
        nextHigher := len(nums)-1
        for nextHigher >= lastMini+1 && nums[lastMini] >= nums[nextHigher] { // 步骤二：在[lastMini+1, n)从右向左查找第一个大于lastMini的数；由于该区间降序，该数满足大于lastMini的数里面最接近lastMini的数！！！
            nextHigher--
        }
        nums[lastMini], nums[nextHigher] = nums[nextHigher], nums[lastMini] // 步骤三：交换两数；区间[lastMini+1, n)仍为降序！！！
    }
    reverse(nums, lastMini+1, len(nums)-1) // 步骤四：将区间[lastMini+1, n)反转变为升序即可！！！
}

func reverse(nums []int, left int, right int) {
    for left < right {
        nums[left], nums[right] = nums[right], nums[left]
        left++
        right--
    }
}