func luckyNumbers (matrix [][]int) []int { // 通过反证法可证明该题最多仅存在一个幸运数！！！
    m, n := len(matrix), len(matrix[0])

    rowMin := make([]int, m)
    columMax := make([]int, n)

    for i:=0; i<m; i++ { // 遍历二维数组，存储每行的最小值以及每列的最大值！！！
        rowMin[i] = math.MaxInt32
        for j:=0; j<n; j++ {
            rowMin[i] = min(rowMin[i], matrix[i][j])       
            columMax[j] = max(columMax[j], matrix[i][j])
        }
    }

    var result []int = []int{}
    for i:=0; i<m; i++ { // 再次遍历二维数组，将当前元素与当前行最小值及当前列最大值比较，皆相等则为幸运数！！！
        for j:=0; j<n; j++ {
            if matrix[i][j] == rowMin[i] && matrix[i][j] == columMax[j] {
                result = append(result, matrix[i][j])
            }
        }
    }

    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}