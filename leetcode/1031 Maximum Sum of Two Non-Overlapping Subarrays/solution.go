func maxSumTwoNoOverlap(nums []int, firstLen int, secondLen int) int { //「前缀和」+「分类解决」！！！
    L, M := firstLen, secondLen
    preSum := make([]int, len(nums)+1)
    for i:=1; i<=len(nums); i++ {
        preSum[i] = preSum[i-1] + nums[i-1] // 存储前缀和！！！
    }
    max1 := findMax(nums, L, M, preSum) // case1：长度为 L 的连续子数组在左边, 长度为 M 的连续子数组在右边！！！
    max2 := findMax(nums, M, L, preSum) // case2：长度为 M 的连续子数组在左边, 长度为 L 的连续子数组在右边！！！
    return maxTwo(max1, max2)
}

func findMax(nums []int, l int,  r int, preSum []int) int { //「l」和「r」分别代表左边和右边连续字数组的长度！！！
    lMax, rMax := preSum[l], preSum[l+r]-preSum[l]
    max := lMax + rMax
    for i:=l+1; i+r <= len(nums); i++ {
        lMax = maxTwo(lMax, preSum[i]-preSum[i-l])
        rMax = preSum[i+r] - preSum[i] // 细节：左边的数组最大和每次需要更新；右边的数组之和不能够重叠，每次作为滑动窗口右移即可！！！
        max = maxTwo(max, lMax + rMax) // 两数组最大和每次检查更新即可！！！
    }
    return max
}

func maxTwo(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}