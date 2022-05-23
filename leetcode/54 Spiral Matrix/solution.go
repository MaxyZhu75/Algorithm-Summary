func spiralOrder(matrix [][]int) []int { // ��ÿ��߽�������ɲο�LeetCode�ٷ�ͼ�⣡����
    left, right, top, bottom := 0, len(matrix[0])-1, 0, len(matrix)-1 // ���������ĸ��߽磡����
    result := []int{}
    for left <= right && top <= bottom {
        for colum := left; colum <= right; colum++ { // �ϱ߽磡����
            result = append(result, matrix[top][colum])
        }
        for row := top+1; row <= bottom; row++ { // �ұ߽磡����
            result = append(result, matrix[row][right])
        }
        if left < right && top < bottom {
            for colum := right-1; colum > left; colum-- { // �±߽磡����
                result = append(result, matrix[bottom][colum])
            }
            for row := bottom; row > top; row-- { // ��߽磡����
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