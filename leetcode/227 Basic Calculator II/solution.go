func calculate(s string) int {
    n := len(s)
    preOperand := '+'
    num := 0 // 待处理数字！！！
    myStack := []int{}
    for i, letter := range s {
        isDigit := (letter >= '0') && (letter <= '9') // 当前字符为数字；记住该统计数字的操作（套路）！！！
        if isDigit {
            num = num*10 + int(letter-'0')
        }
        if !isDigit && letter != ' ' || i == n-1 { // 当前字符为「操作符」或「最后一位」！！！
            switch preOperand { // 注意此处是在对「前一个操作符」进行运算！！！
                case '+':
                    myStack = append(myStack, num)
                case '-':
                    myStack = append(myStack, -num)
                case '*':
                    myStack[len(myStack)-1] *= num
                default:
                    myStack[len(myStack)-1] /= num
            }
        preOperand = letter
        num = 0 // 待处理数字「归零」！！！
        }
    }

    result := 0
    for _, num := range myStack { // 最后循环累加栈内结果！！！
        result += num
    }
    return result
}
