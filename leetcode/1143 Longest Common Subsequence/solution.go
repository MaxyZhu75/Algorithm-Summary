func longestCommonSubsequence(text1 string, text2 string) int {
    m, n := len(text1), len(text2)
    d := make([][]int, m+1) // ����dp������
    for i:=0; i<m+1; i++ {
        d[i] = make([]int, n+1)
    }

    for i, byte1 := range text1 {
        for j, byte2 := range text2{
            if byte1 == byte2 { // ת�Ʒ��̣�����
                d[i+1][j+1] = d[i][j] + 1 // case1����λ�������ַ�����ĸƥ�䣡����
            } else {
                d[i+1][j+1] = twoMax(d[i+1][j], d[i][j+1]) // case2����λ�������ַ�����ƥ�䣡����
            }
        }
    }

    return d[m][n]
}

func twoMax(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}