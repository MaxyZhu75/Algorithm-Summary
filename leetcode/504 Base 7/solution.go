func convertToBase7(num int) string {
    if num == 0 {
        return "0"
    }

    isNegative := false // 先化为正数处理！！！
    if num < 0 {
        num = -num
        isNegative = true
    }

    var result string = ""
    for (num > 0) { // 注意高低位顺序问题！！！
        oneBit := strconv.Itoa(num % 7)
        result = oneBit + result
        num /= 7
    }

    if isNegative {
        result = "-" + result // 判断是否补上负号！！！
    }

    return result
}