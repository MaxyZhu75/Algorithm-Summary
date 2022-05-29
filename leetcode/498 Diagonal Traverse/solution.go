func findDiagonalOrder(mat [][]int) []int { // 分析题目找规律！！！
    m, n := len(mat), len(mat[0])
    result := []int{}
    direction, up, down, upMax, downMax := 0, 0, 0, 0, 0 // 两种方向交替；某一对角线由开始到结束，横纵坐标总是一增一减，且各元素的横纵坐标之和相同！！！
    for indexSum:=0; indexSum <= m+n-2; indexSum++ { // 遍历不同对角线即由小到大遍历不同坐标之和！！！
        if direction == 0 { // 确定递增递索引与递减索引的边界！！！
            downMax, upMax = m, n
        } else {
            downMax, upMax = n, m
        }
        if indexSum < downMax { // 确定递增递索引与递减索引的初始值！！！
            down = indexSum
        } else {
            down = downMax-1
        }
        up = indexSum - down

        for down >= 0 && up < upMax { // 判断当前方向，遍历当前对角线上的元素！！！
            if direction == 0 {
                result = append(result, mat[down][up]) // 注意横纵坐标的增减性每轮会反转，应根据对角线的方向，确定i与j分别是递增还是递减！！！
            } else {
                result = append(result, mat[up][down])
            }
            down--
            up++
        }
        
        direction = 1 - direction // 对角线方向反转！！！
    }
    return result
}