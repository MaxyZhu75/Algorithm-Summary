func searchMatrix(matrix [][]int, target int) bool {
    n, m := len(matrix), len(matrix[0])
    i, j := n-1, 0
    for (i >=0 && j <m) { //���������½ǡ�Ϊ��㣡����
        if matrix[i][j] == target {
            return true
        } else if matrix[i][j] < target {
            j++
        } else {
            i--
        }
    }
    return false
}