func isPalindrome(s string) bool { // 双指针；无需额外空间！！！
    s = strings.ToLower(s) // 先全部转为小写！！！
    left, right := 0, len(s) - 1
    for left < right {
        for left < right && !isLetterOrDigit(s[left]) { // 每次循环先将左右指针移至字母或数字停下！！！
            left++
        }
        for left < right && !isLetterOrDigit(s[right]) {
            right--
        }
        if left < right { // 若左右指针未重叠交叉，则进行比较！！！
            if s[left] != s[right] {
                return false
            }
            left++
            right--
        }
    }
    return true
}

func isLetterOrDigit(c byte) bool { // 手写Java方法Character.isLetterOrDigit()！！！
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
}