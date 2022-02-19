func minMoves2(nums []int) int { // 这是一个经典的数学问题，假设最终数组中的每个数均为x，当x为这个N个数的中位数时，可以使得距离最小！！！
    sort.Ints(nums) // 若N为奇数，则x必须为这N个数中的唯一中位数！！！
    median, result := nums[len(nums)/2], 0 // 若N为偶数，中间的两个数为p和q，中位数为(p+q)/2，此时x只要是区间[p,q]中的任意一个数即可！！！
    for _, num := range nums { // 确定中位数的位置还可以使用快速排序，速度会更快！！！
        result += abs(num-median)
    }
    return result
}

func abs(a int) int {
    if a >= 0 {
        return a
    } else {
        return -a
    }
}