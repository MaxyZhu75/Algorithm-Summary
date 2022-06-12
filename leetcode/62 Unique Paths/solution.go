func uniquePaths(m int, n int) int { // 数学方法！！！
    result := 1 // 本题从左上角到右下角需移动(m-1)+(n-1)次，因此结果等于从m+n-2次中选m-1次向下移动！！！
    x, y := n, 1
    for y < m { //「(m+n-2)!/(m-1)!(n-1)!」的展开式化简等于「(m+n-2)...(n+1)n/(m-1)!」；循环「m-2」次！！！
        result = (result * x) / y
        x++
        y++
    }
    return result 
}