func myAtoi(s string) int {
    n, result, pointer := len(s), 0, 0
    negative := false
    
    for pointer < n && s[pointer] == ' ' { // 步骤一：丢弃无用的前导空格！！！
        pointer++
    }

    if pointer == n { // 步骤二：检查指针是否达到末尾，并尝试读取正负号！！！
        return result
    }
    if s[pointer] == '-' {
        negative = true
        pointer++
    } else if s[pointer] == '+' {
        pointer++
    }

    currentDigit := 0
    for pointer < n && s[pointer] >= '0' && s[pointer] <= '9' { // 步骤三：对数字部分进行处理！！！
        currentDigit = int(s[pointer] - '0')
        result = result*10 + currentDigit // 使用Go语言时，result可以先进行运算，再直接判断是否溢出即可，因为int为64位！！！
        if result > math.MaxInt32 {
            if negative == true {
                return math.MinInt32
            } else {
                return math.MaxInt32
            }
        }
        pointer++
    }

    if negative == true {
        return -1 * result
    } else {
        return result
    }
}