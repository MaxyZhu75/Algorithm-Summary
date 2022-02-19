func luckyNumbers (matrix [][]int) []int { // ͨ����֤����֤��������������һ��������������
    m, n := len(matrix), len(matrix[0])

    rowMin := make([]int, m)
    columMax := make([]int, n)

    for i:=0; i<m; i++ { // ������ά���飬�洢ÿ�е���Сֵ�Լ�ÿ�е����ֵ������
        rowMin[i] = math.MaxInt32
        for j:=0; j<n; j++ {
            rowMin[i] = min(rowMin[i], matrix[i][j])       
            columMax[j] = max(columMax[j], matrix[i][j])
        }
    }

    var result []int = []int{}
    for i:=0; i<m; i++ { // �ٴα�����ά���飬����ǰԪ���뵱ǰ����Сֵ����ǰ�����ֵ�Ƚϣ��������Ϊ������������
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