func splitArray(nums []int, m int) int { // 二分的上界为数组中所有元素的和，下界为数组中所有元素的最大值！！！
    maxNum, sum := 0, 0
    for _, num := range nums {
        sum += num
        if maxNum < num {
            maxNum = num
        }
    }

    low, high := maxNum, sum // 二分查找！！！
    for low < high {
        mid := low + (high-low)/2
        if check(nums, mid, m) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

func check(nums []int, upperBound int, m int) bool { // 验证是否存在一种分割为m组的方案，满足其最大分割子数组的和不超过upperBound！！！
    subsetSum, count := 0, 1
    for _, num := range nums {
        if subsetSum + num > upperBound { // case1：若添加则越界，此处需要划分新的组！！！
            count++
            subsetSum = num
        } else {
            subsetSum += num // case2：添加不会越界，则视作当前组的元素！！！
        }
    }
    return count <= m // 由于m一定大于nums.length，因此只要划分为count<m组的方案存在，划分为m组的方案也必然存在！！！
}