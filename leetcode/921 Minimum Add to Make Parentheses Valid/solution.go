func minAddToMakeValid(s string) int { // 方法二：维护balance变量！！！
    left, balance := 0, 0
    for _, letter := range s {
        if letter == '(' {
            balance++
        } else {
            if balance > 0 {
                balance--
            } else {
                left++
                balance = 0
            }
        }
    }
    return left + balance // 需要添加的左括号数量 + 需要添加的右括号数量！！！
}
