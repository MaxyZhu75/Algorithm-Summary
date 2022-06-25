func calculate(s string) int { // 方法二：栈记录正负号！！！
    n := len(s)
    myStack := []int{1} // 栈顶元素记录了当前位置所处的每个括号所「共同形成」的符号！！！
    sign, result := 1, 0 // 记录当前符号！！！

    for i := 0; i < n; {
        if s[i] == ' ' { // case1：空字符跳过！！！
            i++;
        } else if s[i] == '+' {
            sign = myStack[len(myStack)-1] // case2：加号，正确获取当前计算符号！！！
            i++
        } else if s[i] == '-' {
            sign = -myStack[len(myStack)-1] // case3：减号，正确获取当前计算符号！！！
            i++
        } else if s[i] == '(' {
            myStack = append(myStack, sign) // case4：左括号，将该括号总的运算符号压入栈顶！！！
            i++
        } else if s[i] == ')' {
            myStack = myStack[:len(myStack)-1] // case5：右括号，结束数值计算，将该括号总的运算符号弹出栈顶！！！
            i++
        } else { // case6：数字计算！！！
            num := 0
            for i < n && s[i] >= '0' && s[i] <= '9'{ // 字符串转数字处理！！！
                num = num * 10 + int(s[i] - '0')
                i++
            }
            result += sign * num
        }
    }
    return result
}
