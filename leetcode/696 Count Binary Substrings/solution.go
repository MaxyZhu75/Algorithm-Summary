func countBinarySubstrings(s string) int {
    n := len(s)
    pointer, preLen, result := 0, 0, 0 // 将preLen初始化为0！！！

    for (pointer < n) {
        group := s[pointer] // 当前分组字符！！！
        currentLen := 0
        for (pointer < n && s[pointer] == group) { // 统计当前组长度！！！
            pointer++
            currentLen++
        }
        result += min(currentLen, preLen) // 相邻的组代表不同字符，加入result时，符合题目要求的子串数量应该等于相邻组中较短的的那一组的长度（结合题意理解）！！！
        preLen = currentLen
    }

    return result
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}