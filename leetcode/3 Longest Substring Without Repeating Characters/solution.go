func lengthOfLongestSubstring(s string) int { // 滑动窗口虫取法！！！
    hashRecord := make(map[byte]int)
    left, right := 0, 0
    for right < len(s) {
        _, ok := hashRecord[s[right]]
        if ok {
            hashRecord[s[right]]++
        } else {
            hashRecord[s[right]] = 1
        }
        if len(hashRecord) < (right-left+1) {
            hashRecord[s[left]]--
            if hashRecord[s[left]] == 0 {
                delete(hashRecord, s[left])
            }
            left++
        }
        right++
    }
    return right-left
}
