func selfDividingNumbers(left int, right int) []int {
    result := []int{}
    for i:=left; i<=right; i++ {
        if isSelfDividing(i) {
            result = append(result, i)
        }
    }
    return result
}

func isSelfDividing(num int) bool {
    n := num // 需要辅助变量！！！
    for n > 0 {
        digit := n % 10
        if digit == 0 || num % digit != 0 {
            return false
        }
        n /= 10
    }
    return true
}