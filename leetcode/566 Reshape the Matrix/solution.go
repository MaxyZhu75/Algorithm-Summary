func matrixReshape(mat [][]int, r int, c int) [][]int {
    m, n := len(mat), len(mat[0])
    if m*n != r*c {
        return mat
    }

    result := make([][]int, r)
    for i:=0; i<r; i++ {
        result[i] = make([]int, c)
    }

    count := 0 // 记录已处理的元素个数！！！

    for i:=0; i<r; i++ {
        for j:=0; j<c; j++ {
            flattenRow := count / n // 机器学习中的flatten操作，可记住该变换！！！
            flattenColum := count % n
            result[i][j] = mat[flattenRow][flattenColum]
            count++
        }
    }

    return result
}