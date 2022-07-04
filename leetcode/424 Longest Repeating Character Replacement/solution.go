func characterReplacement(s string, k int) int { // 滑动窗口虫取法！！！
    count := [26]int{}
    maxCount, left, right := 0, 0, 0
    for right < len(s) {
        count[int(s[right]-'A')]++
        if count[int(s[right]-'A')] > maxCount {
            maxCount = count[int(s[right]-'A')];
        }
        if right-left+1 - maxCount > k {
            count[int(s[left]-'A')]--
            left++
        }
        right++
    }
    return right-left
}