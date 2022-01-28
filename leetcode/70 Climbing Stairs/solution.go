func climbStairs(n int) int {
    if n <= 2 { // basecase需要直接返回！！
        return n;
    }
    d := make([]int, n+1) // 建立dp表；另外该题也可以只使用两个变量在循环内进行更新及存储，空间复杂度为O(1)！！！
    d[1] = 1 // basecase赋值！！！
    d[2] = 2
    for i:=3; i<n+1; i++ {
        d[i] = d[i-1] + d[i-2] // 确定dp方程；用循环填dp表！！！
    }
    return d[n]
}