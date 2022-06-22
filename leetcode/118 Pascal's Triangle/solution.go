func generate(numRows int) [][]int { // 根据定义模拟即可！！！
    result := [][]int{}
    for i:=0; i<numRows; i++ {
        current := []int{}
        for j:=0; j<=i; j++ {
            if j == 0 || j == i {
                current = append(current, 1)
            } else {
                current = append(current, result[i-1][j-1] + result[i-1][j])
            }
        }
        result = append(result, current)
    }
    return result
}