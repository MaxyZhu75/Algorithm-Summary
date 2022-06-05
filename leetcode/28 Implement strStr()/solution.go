func strStr(haystack string, needle string) int { // 滑动窗口暴力解法！！！
    n, m := len(haystack), len(needle)
    for i:=0; i+m <=n; i++ {
        match := true
        for j:=0; j<m; j++ {
            if haystack[i+j] != needle[j] {
                match = false
                break
            }
        }
        if match == true {
            return i
        }
    }
    return -1
}