func sumZero(n int) []int { // [0], [-1,1], [-1,1,0], [-2,-1,1,2], [-2,-1,-1,2,0]......！！！
    A := make([]int, n) // 细节：n为奇数时数组末尾为初始化元素0！！！
    index := 0
    for i:=1; i<=n/2; i++ { // 细节：注意循环由1到n/2！！！
        A[index] = -i
        index++
        A[index] = i
        index++
    }
    return A
}