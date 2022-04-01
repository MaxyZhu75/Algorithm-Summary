func calculate(s string) int { // 利用Stack来完成；记住该题套路！！！
    n := len(s)
    preOperand := '+' // 注意存储的是前一个操作符，不是当前的！！！
    digit := 0 // 待处理数字！！！
    myStack := []int{}
    for i, letter := range s {
        isDigit := (letter >= '0') && (letter <= '9') // case1：当前字符为数字；记住该统计数字的操作（套路）！！！
        if isDigit {
            digit = digit*10 + int(letter-'0')
        }
        if !isDigit && letter != ' ' || i == n-1 { // case2：当前字符为操作符或最后一位字符！！！
            switch preOperand { // 注意此处是在对前一个操作符及数字进行运算！！！
                case '+':
                    myStack = append(myStack, digit)
                case '-':
                    myStack = append(myStack, -digit)
                case '*':
                    myStack[len(myStack)-1] *= digit
                default:
                    myStack[len(myStack)-1] /= digit
            }
        preOperand = letter // 当前操作符记为前一个操作符，等待处理！！！
        digit = 0 // 待处理数字归零！！！
        }
    }

    result := 0
    for _, num := range myStack {
        result += num
    }
    return result
}