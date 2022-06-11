func spiralOrder(matrix [][]int) []int { // 按每层边界遍历；可参考LeetCode官方图解！！！
    left, right, top, bottom := 0, len(matrix[0])-1, 0, len(matrix)-1 // 上下左右四个边界！！！
    result := []int{}
    for left <= right && top <= bottom {
        for j := left; j <= right; j++ { // 上边界！！！
            result = append(result, matrix[top][j])
        }
        for i := top+1; i <= bottom; i++ { // 右边界！！！
            result = append(result, matrix[i][right])
        }
        if left < right && top < bottom {
            for j := right-1; j > left; j-- { // 下边界！！！
                result = append(result, matrix[bottom][j])
            }
            for i := bottom; i > top; i-- { // 左边界！！！
                result = append(result, matrix[i][left])
            }
        }
        left++
        right--
        top++
        bottom--
    }
    return result
}
