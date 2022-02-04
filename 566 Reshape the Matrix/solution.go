func matrixReshape(mat [][]int, r int, c int) [][]int {
    m, n := len(mat), len(mat[0])
    if m*n != r*c {
        return mat
    }

    result := make([][]int, r)
    for i:=0; i<r; i++ {
        result[i] = make([]int, c)
    }

    count := 0 // ��¼�Ѵ����Ԫ�ظ���������

    for i:=0; i<r; i++ {
        for j:=0; j<c; j++ {
            flattenRow := count / n // ����ѧϰ�е�flatten�������ɼ�ס�ñ任������
            flattenColum := count % n
            result[i][j] = mat[flattenRow][flattenColum]
            count++
        }
    }

    return result
}