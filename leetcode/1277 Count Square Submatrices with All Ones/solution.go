func countSquares(matrix [][]int) int { // ��̬�滮������
    m, n, result := len(matrix), len(matrix[0]), 0
    d := make([][]int, m+1) // d[i][j]��ʾ��(i, j)Ϊ���½ǵġ����������߳����������ε���Ŀ��������
    for i:=0; i<m; i++ {
        d[i] = make([]int, n+1)
    }
    for i:=0; i<m; i++ {
        for j:=0; j<n; j++ {
            if i == 0 || j ==0 { // ת�Ʒ��̷��������������
                d[i][j] = matrix[i][j]
            } else if matrix[i][j] == 0 {
                d[i][j] = 0
            } else {
                d[i][j] = min(d[i-1][j], d[i][j-1], d[i-1][j-1]) + 1
            }
            result += d[i][j] // �ۼ���������Ŀ������
        }
    }
    return result
}

func min(a int, b int, c int) int {
    if a <= b && a <= c {
        return a
    } else if b <= a && b <= c {
        return b
    } else {
        return c
    }
}