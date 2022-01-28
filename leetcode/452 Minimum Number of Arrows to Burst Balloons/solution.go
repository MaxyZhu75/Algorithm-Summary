func findMinArrowShots(points [][]int) int { // 相当于在问不重叠的区间个数，但注意重叠的定义有区别，端点相同也算重叠，如[1, 2]与[2, 3]！！！
   
    sort.Slice(points, func(i int, j int) bool { // 该贪心思想与LeetCode的435题相同！！！
        return points[i][1] < points[j][1]
    })

    var previous []int = points[0]
    shots := 1
    for _, point := range points {
        if point[0] > previous[1] {
            shots++
            previous = point
        }
    }
    return shots
}