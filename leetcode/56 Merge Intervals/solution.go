func merge(intervals [][]int) [][]int {
    sort.SliceStable(intervals, func(i int, j int) bool { // 先按左端点从小到大排序！！！
        return intervals[i][0] < intervals[j][0]
    })

    n := len(intervals)
    left, right, preRight := intervals[0][0], intervals[0][1], 0
    result := [][]int{{left, right}}
    for i:=1; i<n; i++ {
        left = intervals[i][0]
        right = intervals[i][1]
        preRight = result[len(result)-1][1] // 获取result末尾元素的右端点！！！
        if left > preRight {
            result = append(result, []int{left, right}) // case1：若当前区间左端点与前一区间右端点不相交，则将当前区间添加入result！！！
        } else {
            result[len(result)-1][1] = max(preRight, right) // case2：若当前区间左端点与前一区间右端点相交，则需要检查更新result末尾元素的右端点！！！
        }
    }
    return result
}

func max(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}