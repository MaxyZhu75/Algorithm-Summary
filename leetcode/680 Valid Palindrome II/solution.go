func validPalindrome(s string) bool {
    var p1, p2 int = 0, len(s)-1
    for (p1 < p2) {
        if s[p1] == s[p2] { // case1：如果0是回文，则循环结束返回true！！！
            p1++
            p2--
        } else { // case2：由于题目表示可以删除一个字符，若出现一次不相等，则还可以调用isPalindrome判断剩下的部分是否严格是回文（不能再次删除字母）！！！
            return isPalindrome(s, p1+1, p2) || isPalindrome(s, p1, p2-1) // 删除的字符有两种情况，删除后若有一种满足回文即可，此处直接return或运算结果！！！
        }
    }
    return true
}

func isPalindrome(s string, i int, j int) bool { // 与回文有关的题目常常需要定义该方法，需要熟练掌握！！！
    var p1, p2 int = i, j
    for (p1 < p2) {
        if s[p1] == s[p2] { // Go语言中string类型直接使用S[i]返回字符，相当于java中String.charAt()！！！
            p1++
            p2--
        } else {
            return false
        }
    }
    return true
}