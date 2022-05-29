func rotate(matrix [][]int)  { // 观察可知操作可拆解为两步！！！
    n := len(matrix)
    for i:=0; i<n/2; i++ { // Step1：水平上下翻转！！！
        for j:=0; j<n; j++ {
            matrix[i][j], matrix[n-i-1][j] = matrix[n-i-1][j], matrix[i][j]
        }
    }
    for i:=0; i<n; i++ { // Step2：矩阵转置（按主对角线翻转）！！！
        for j:=0; j<i; j++ {
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
}