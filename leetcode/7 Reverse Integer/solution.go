func reverse(x int) int { // 数学推导见官方题解！！！
    reverse := 0
    for x != 0 {
        if reverse < math.MinInt32 / 10 || reverse > math.MaxInt32 / 10 { // 判断reverse是否属于[-2^31, 2^31 - 1]的简化条件！！！
            return 0
        }
        digit := x % 10 // 反转数字的常规方法！！！
        reverse = reverse * 10 + digit
        x /= 10
    }
    return reverse
}