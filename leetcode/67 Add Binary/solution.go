func addBinary(a string, b string) string {
    p1, p2, carry := len(a)-1, len(b)-1, 0 // 要点一：指针从后往前符合二进制从低位相加的模拟！！！
    var result string = "" 

    for (p1 >= 0 || p2 >= 0 || carry == 1) {
        sum := carry
        if p1 >= 0 {
            sum += int(a[p1]-'0') // Go从字符串中提取数字字符或字母字符后，需要减相应的‘0’或‘a’，且再使用强制转型！！！
        }
        if p2 >= 0 {
            sum += int(b[p2]-'0')
        }
        carry = sum/2 // 要点二：二进制数学运算！！！
        result = strconv.Itoa(sum%2) + result  // 进位 = (carry+a+b)/2；当前bit = (carrry+a+b)%2！！！
        p1--
        p2--
    }

    return result
}