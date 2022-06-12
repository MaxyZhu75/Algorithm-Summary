func shipWithinDays(weights []int, days int) int { // 转化为判定问题的「二分查找」；与LeetCode第875，1231题类似！！！！！！
    max, sum := 0, 0
    for _, weight := range weights {
        sum += weight
        if weight > max {
            max = weight
        }
    }

    low, high := max, sum // 起始左边界为单个货物最大重量；起始右边界为所以重量之和！！！
    for low < high {
        mid := (high-low)/2 + low
        period, currentLoad := 1, 0 // 以mid为装载上限，period表示最少运送天数，currentLoad记录当天已运载重量！！！
        for _, weight := range weights {
            if currentLoad + weight > mid {
                period++
                currentLoad = 0
            }
            currentLoad += weight
        }
        if period <= days { // 排除无效的装载上限，找出最小的有效装载上限！！！
            high = mid 
        } else {
            low = mid+1
        }
    }
    return low
}