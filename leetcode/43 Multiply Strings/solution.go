func multiply(num1 string, num2 string) string { // 算法按照小学乘法竖式运算规则即可！！！
    m, n := len(num1), len(num2)
    digits := make([]int, m+n)
    for i:=m-1; i>=0; i-- {
        for j:=n-1; j>=0; j-- {
            p1, p2 := i+j, i+j+1
            multiply := int(num1[i] - '0') * int(num2[j] - '0') // 此处可以用减法转换为整形！！！
            digits[p1] += (multiply + digits[p2]) / 10 // 注意：此处用「+=」累加nums2低位运算的结果！！！
            digits[p2] = (multiply + digits[p2]) % 10 // 运算结果记得要加上一层的进位digits[p2]！！！
        }
    }
    sb := []byte{}
    for _, digit := range digits {
        if !(len(sb) == 0 && digit == 0) { // 需要跳过所有前导0！！！
            sb = append(sb, byte(digit + '0'))
        }
    }
    if len(sb) == 0 {
        return "0"
    } else {
        return string(sb)
    }
}