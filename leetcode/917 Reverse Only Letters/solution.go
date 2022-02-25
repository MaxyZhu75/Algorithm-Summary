func reverseOnlyLetters(s string) string { // 双指针即可；注意if-else结构，不是字母时当前循环只动一个指针！！！
    chars := []byte(s) // String不可变，先转为字符数组！！！
    p1, p2 := 0, len(s)-1
    for p1 < p2 {
        if !(s[p1]>='a' && s[p1]<='z') && !(s[p1]>='A' && s[p1]<='Z') { // 写法一：单个字符可直接比较！！！
            p1++
        } else if !(s[p2]>='a' && s[p2]<='z') && !(s[p2]>='A' && s[p2]<='Z') {
            p2--
        } else if unicode.IsLetter(rune(s[p1])) && unicode.IsLetter(rune(s[p2])) { // 写法二：导包import "unicode"；IsLetter()函数内要强制转换为另一种字符类型rune（UTF-8字符）！！！
            chars[p1], chars[p2] = chars[p2], chars[p1]
            p1++
            p2--
        }
    }

    return string(chars)
}