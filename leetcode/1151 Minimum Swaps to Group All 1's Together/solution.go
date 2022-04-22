func minSwaps(data []int) int { // 滑动窗口！！！
    n := len(data)
    windowsize := 0
    for i:=0; i<n; i++ {
        windowsize += data[i] // 滑动窗口大小 = 数组中1的总数！！！
    }

    countOne := 0
    for i:=0; i<windowsize; i++ {
        countOne += data[i] // 统计滑动窗口在初始位置，窗口内1的数量！！！
    }

    maxOne := countOne // 滑动窗口将向右滑动，更新记录窗口内1的最大数量！！！
    for i:=windowsize; i<n; i++ {
        countOne += data[i] // 入！！！
        countOne -= data[i-windowsize] // 出！！！
        if maxOne < countOne {
            maxOne = countOne
        }
    }

    return windowsize - maxOne // 需要交换的最小次数即窗口内0的最小数量！！！
}