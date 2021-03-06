func minEatingSpeed(piles []int, h int) int { // 「二分查找」判断问题；与LeetCode第1011，1231题类似！！！
    max := 0
    for _, pile := range piles {
        if pile > max {
            max = pile
        }
    }
    low, high := 1, max
    for low < high {
        mid := (high-low)/2 + low // 以mid为每小时胃口上限，period表示最少吃完全部香蕉的时间！！！
        period := 0
        for _, pile := range piles { // 注意每小时只吃一堆；某一堆超过胃口时需要吃多个小时！！！
            if pile > mid {
                period += (pile+mid-1)/mid // 优化时间写法；此处等价于调用 Math.ceil(pile*1.0 / mid)！！！
            } else {
                period++
            }
        }
        if (period <= h) {
            high = mid
        } else {
            low = mid+1
        }
    }
    return low
}