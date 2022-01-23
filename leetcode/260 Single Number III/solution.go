func singleNumber(nums []int) []int {
    var allXor int = 0 // 0与任意整数n异或（0^n），结果为n本身！！！
    for _, num := range nums {
        allXor ^= num // 由于整数n与自身异或（n^n）结果为0，将数组元素全部异或的结果即等于两个只出现一次的数字的异或结果！！！
    }
    feature := allXor & (-allXor) // 要点：对于任意整数n，位运算n&(-n)的结果为n最低位的1；此处则表示两个只出现一次的数字在二进制表示下最低的二者出现不同的位！！！
    group1, group2 := 0, 0
    var result = make([]int, 2)
    for _, num := range nums {
        if feature&num == 0 { // 此时可以由feature这一特征（第i位上为0或1），将数组分为两组，注意两个只出现一次的数字必然在不同组！！！
            group1 ^= num
        } else {
            group2 ^= num
        }
    }
    result[0], result[1] = group1, group2 // 两个只出现一次的数字各自在不同组；由于其他元素皆出现两次，整数n与自身异或（n^n）结果为0，故各组异或运算后的结果即为答案！！！
    return result
}