func addStrings(num1 string, num2 string) string { // 指针从后往前符合十进制从低位相加的模拟；与LeetCode67题类似！！！
    p1, p2 := len(num1)-1, len(num2)-1
    carry := 0;
    var result string = ""

    for (p1 >= 0 || p2 >= 0 || carry == 1) {
        a, b := 0, 0
        if p1 >= 0 {
            a = int(num1[p1] - '0') // Go从字符串中提取数字字符或字母字符后，需要减相应的‘0’或‘a’，且再使用强制转型！！！
        }

        if p2 >= 0 {
            b = int(num2[p2] - '0')
        }

        sum := (a + b + carry) % 10 // 进位 = (carry+a+b)/10；当前bit = (carrry+a+b)%10！！！
        carry = (a + b + carry) / 10
        result = strconv.Itoa(sum) + result
        p1--
        p2--
    }

    return result
}
