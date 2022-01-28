func eraseOverlapIntervals(intervals [][]int) int { // 经典选课贪心：按课程结束时间排序，每次选择最早结束的！！！
    var allClass, scheduledClass int = len(intervals), 1

    sort.Slice(intervals, func(i int, j int) bool { // import "sort"；重点记住该排序方式！！！
        return intervals[i][1] < intervals[j][1] // 要借用intervals及索引来表达；返回的是bool！！！
    })

    var previous []int = intervals[0]
    for _, interval := range intervals {
        if interval[0] >= previous[1] {
            scheduledClass++
            previous = interval
        }
    }
    return allClass - scheduledClass
}