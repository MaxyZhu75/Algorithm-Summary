func constructArray(n int, k int) []int { // 让前k+1个元素构建出k个不相同的差值，序列为：1, k+1, 2, k, 3, k-1, ... , k/2, k/2+1, k+2, k+3, ... , n-1, n ！！！
    result := make([]int, n)
    result[0] = 1
    difference := k
    for i:=1; i<=k; i++ { // 前k+1个数交叉构造！！！
        if i % 2 == 1 {
            result[i] = result[i-1] + difference
        } else {
            result[i] = result[i-1] - difference
        }
        difference--
    }

    for i:=k+1; i<n; i++ { // 剩余的数顺序填满！！！
        result[i] = i+1
    }

    return result
}