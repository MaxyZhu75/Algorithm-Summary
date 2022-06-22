func grayCode(n int) []int { // 格雷码公式！！！
    result := make([]int, 1<<n)
    for i:=0; i<(1<<n); i++ {
        result[i] = (i>>1) ^ i // 公式:「g(i)=b(i+1)⊕b(i)」；b(i)为当前二进制数的第i+1位！！！
    }
    return result
}