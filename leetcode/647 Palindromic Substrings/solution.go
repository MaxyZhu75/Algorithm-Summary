var result int

func countSubstrings(s string) int { // 该题若使用传统判断回文方法isPalindrome()时间复杂度为n的三次方；使用中心扩展判断回文则能缩短到n的平方！！！
    result = 0
    for i:=0; i<len(s); i++ {
        extendPalindrome(s, i, i); // 奇数长度回文，中心仅一个元素！！！
        extendPalindrome(s, i, i+1) // 偶数长度回文，中心有两个元素！！！
    }
    return result
}

func extendPalindrome(s string, left int , right int) {
    for (left >= 0 && right < len(s) && s[left] == s[right]) { // 由中心往两边拓展，每成功拓展一次结果加1，若失败则不必再以当前起点拓展！！
        left--
        right++
        result++
    }
}