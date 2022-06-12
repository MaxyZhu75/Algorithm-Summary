func generateMatrix(n int) [][]int { // ��ÿ��߽�������ɲο�LeetCode�ٷ�ͼ�⣡����
    matrix := make([][]int, n)
    for i:=0; i<n; i++ {
        matrix[i] = make([]int, n)
    }
    num := 1
    left, right, top, bottom := 0, n-1, 0, n-1 // ���������ĸ��߽磡����
    for left <= right && top <= bottom {
        for j := left; j <= right; j++ { // �ϱ߽磡����
            matrix[top][j] = num
            num++
        }
        for i := top+1; i <= bottom; i++ { // �ұ߽磡��
            matrix[i][right] = num
            num++
        }
        if left < right && top < bottom {
            for j := right-1; j > left; j-- { // �±߽磡����
                matrix[bottom][j] = num
                num++
            }
            for i := bottom; i > top; i-- { // ��߽磡����
                matrix[i][left] = num
                num++
            }
        }
        left++
        right--
        top++
        bottom--
    }
    return matrix
}