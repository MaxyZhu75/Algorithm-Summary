func spiralOrder(matrix [][]int) []int { // 按每层边界遍历；可参考LeetCode官方图解！！！
    left, right, top, bottom := 0, len(matrix[0])-1, 0, len(matrix)-1 // 上下左右四个边界！！！
    result := []int{}
    for left <= right && top <= bottom {
        for colum := left; colum <= right; colum++ { // 上边界！！！
            result = append(result, matrix[top][colum])
        }
        for row := top+1; row <= bottom; row++ { // 右边界！！！
            result = append(result, matrix[row][right])
        }
        if left < right && top < bottom {
            for colum := right-1; colum > left; colum-- { // 下边界！！！
                result = append(result, matrix[bottom][colum])
            }
            for row := bottom; row > top; row-- { // 左边界！！！
                result = append(result, matrix[row][left])
            }
        }
        left++
        right--
        top++
        bottom--
    }
    return result
}