func removePalindromeSub(s string) int {
    if isPalindrome(s, 0, len(s)-1) { // 本题目关键看清楚两个定义（子序列，回文）即可轻而易举地解决；请注意是子序列，而非连续子序列！！！
        return 1
    } else {
        return 2
    }
}

func isPalindrome(s string, i int, j int) bool { // 与回文有关的题目常常需要定义该方法，需要熟练掌握！！
    p1, p2 := i, j
    for (p1 < p2) {
        if s[p1] == s[p2] {
            p1++
            p2--
        } else {
            return false
        }
    }
    return true
}