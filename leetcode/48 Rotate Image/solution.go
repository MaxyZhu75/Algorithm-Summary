func rotate(matrix [][]int)  { // �۲��֪�����ɲ��Ϊ����������
    n := len(matrix)
    for i:=0; i<n/2; i++ { // Step1��ˮƽ���·�ת������
        for j:=0; j<n; j++ {
            matrix[i][j], matrix[n-i-1][j] = matrix[n-i-1][j], matrix[i][j]
        }
    }
    for i:=0; i<n; i++ { // Step2������ת�ã������Խ��߷�ת��������
        for j:=0; j<i; j++ {
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
}