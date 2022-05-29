func arraySign(nums []int) int { // 仅处理符号变化即可，不需要作乘积！！！
    sign := 1
    for _, num := range nums {
        if num == 0 {
            return 0
        } else if num < 0 {
            sign *= -1
        }
    }
    return sign
}