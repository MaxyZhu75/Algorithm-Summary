func rob(nums []int) int { // 该题是基于LeetCode198题的动态规划！！！
    n := len(nums)
    if n == 1 {
        return nums[0]
    }
    if n == 2 {
        return max(nums[0], nums[1]) 
    }

    robEntry := houseRobber(nums, 0, n-2) // case1：抢循环的入口，不抢末尾！！！
    passEntry := houseRobber(nums, 1, n-1) // case2：不抢循环的入口，抢末尾！！！
    return max(robEntry, passEntry)
}

func houseRobber(nums []int, start int, end int) int { // 见LeetCode198题，此处需注意当使用原nums数组时，要从start索引开始即可（视作索引0）！！！
    n := end - start + 1
    if n == 1 {
        return nums[start]
    }
    if n == 2{
        return max(nums[start], nums[end])
    }

    pre1, pre2 := max(nums[start], nums[start+1]), nums[start]
    for i:=2; i<n; i++ {
        current := max(pre1, pre2+nums[start+i])
        pre2 = pre1 
        pre1 = current
    }
    return pre1
}

func max(a int, b int) int {
    if a>= b {
        return a
    } else {
        return b
    }
}