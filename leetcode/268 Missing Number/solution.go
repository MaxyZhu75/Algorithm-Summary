func missingNumber(nums []int) int {
    var n int = len(nums)
    result := 0 // 0与任意整数n异或（0^n），结果为n本身！！！
    for i, num := range nums { // 利用整数n与自身异或（n^n）结果为0的结论，把索引0~n以及每个数组元素进行异或操作，所得结果即为题目所述缺失的数！！！
        result ^= i^num
    }
    result ^= n
    return result
}