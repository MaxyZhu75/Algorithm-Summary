func longestPalindrome(s string) string { // 回文中心拓展法，见LeetCode647题！！！
    start, end := 0, 0
    for i:=0; i<len(s); i++ {
        odd := expandPalindrome(s, i, i) // 奇数长度回文，中心仅一个元素！！！
        even := expandPalindrome(s, i, i+1) // 偶数长度回文，中心有两个元素！！！
        length := max(odd, even)
        if length > end - start {
            start = i - (length-1)/2 // 起点终点索引的计算！！！
            end = i + length/2
        }
    }
    return s[start : end+1] // 注意是「end+1」！！！
}

func expandPalindrome(s string, left int, right int) int {
    for left >= 0 && right < len(s) && s[left] == s[right] { // 由中心往两边拓展，每成功拓展一次结果加1，若失败则不必再以当前起点拓展！！！
        right++
        left--
    }
    return right - left - 1
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}