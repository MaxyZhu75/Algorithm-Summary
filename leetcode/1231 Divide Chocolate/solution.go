func maximizeSweetness(sweetness []int, k int) int { // 「二分查找」判断问题；与LeetCode第1011，875题类似！！！
    min, sum := math.MaxInt32, 0
    for _, sweet := range sweetness {
        sum += sweet
        if sweet < min {
            min = sweet
        }
    }
    low, high, result := min, sum/(k+1), 0 // 自己将吃掉甜度最小的一份；因此自己至少能分到甜度最小的一块，至多能分到平均值！！！
    for low <= high {
        mid := (high-low)/2 + low
        people, currentSweetness := 0, 0 // 以mid为甜度下限，people表示分享人数，currentSweetness记录当前朋友分到的甜度！！！
        for _, sweet := range sweetness {
            currentSweetness += sweet
            if currentSweetness >= mid {
                people++
                currentSweetness = 0
            }
        }
        if people >= k+1 { // 该问题找的是最大甜度下限！！！
            result = mid
            low = mid+1
        } else {
            high = mid-1
        }
    }
    return result
}