func singleNumber(nums []int) int {
    var result int = 0  // 0����������n���0^n�������Ϊn��������
    for _, num := range nums {
        result ^= num  // ����n���������n^n�������Ϊ0������
    }
    return result
}