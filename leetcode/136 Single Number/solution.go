func singleNumber(nums []int) int {
    var result int = 0  // 0与任意整数n异或（0^n），结果为n本身！！！
    for _, num := range nums {
        result ^= num  // 整数n与自身异或（n^n），结果为0！！！
    }
    return result
}