func hammingWeight(num uint32) int { // n&(n-1)�������λ��1������
    count := 0
    for num != 0 {
        num = num & (num-1)
        count++
    }
    return count
}