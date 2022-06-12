func generateMatrix(n int) [][]int { // 按每层边界遍历；可参考LeetCode官方图解！！！
    matrix := make([][]int, n)
    for i:=0; i<n; i++ {
        matrix[i] = make([]int, n)
    }
    num := 1
    left, right, top, bottom := 0, n-1, 0, n-1 // 上下左右四个边界！！！
    for left <= right && top <= bottom {
        for j := left; j <= right; j++ { // 上边界！！！
            matrix[top][j] = num
            num++
        }
        for i := top+1; i <= bottom; i++ { // 右边界！！
            matrix[i][right] = num
            num++
        }
        if left < right && top < bottom {
            for j := right-1; j > left; j-- { // 下边界！！！
                matrix[bottom][j] = num
                num++
            }
            for i := bottom; i > top; i-- { // 左边界！！！
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