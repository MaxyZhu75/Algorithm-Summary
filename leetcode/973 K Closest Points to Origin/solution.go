func kClosest(points [][]int, k int) [][]int {
    sort.Slice(points, func(i int, j int) bool {
        distance1 := points[i][0]*points[i][0] + points[i][1]*points[i][1]
        distance2 := points[j][0]*points[j][0] + points[j][1]*points[j][1]
        return distance1 < distance2 // 距离由小到大，升序排列！！！
    })
    return points[:k]
}