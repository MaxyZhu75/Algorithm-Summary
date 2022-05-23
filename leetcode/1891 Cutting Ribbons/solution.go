func maxLength(ribbons []int, k int) int { // 二分查找！！！
    low, high, result := 1, 1, 0
    for _, ribbon := range ribbons {
        high = max(ribbon, high)
    }
    for low <= high { // 在循环内查找元素，用result记录当前符合条件的结果！！！
        mid := (high-low)/2 + low
        if check(ribbons, k , mid) {
            result = mid
            low = mid+1
        } else {
            high = mid-1
        }
    }
    return result
}

func check(ribbons []int, k int, length int) bool { // 判断是否能够切出k个或以上长度为length的绳子！！！
    count := 0
    for _, ribbon := range ribbons {
        count += ribbon/length
    }
    return count >= k
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}