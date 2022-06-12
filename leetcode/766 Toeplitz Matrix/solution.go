func isToeplitzMatrix(matrix [][]int) bool { // 仅需将每一个元素和它左上角的元素相比对即可；进阶问题见三叶题解！！！
    m, n := len(matrix), len(matrix[0])
    for i:=1; i<m; i++ {
        for j:=1; j<n; j++ {
            if matrix[i][j] != matrix[i-1][j-1] {
                return false
            }
        }
    }
    return true
}