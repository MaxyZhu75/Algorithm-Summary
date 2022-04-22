func lengthOfLongestSubstring(s string) int { // 注意：字串需要连续，子序列不需要连续！！！
    n, result := len(s), 0
    hashSet := map[byte]bool{} // 记住Go语言HashSet写法！！！

    right := 0 // 要点：滑动窗口的右端是不需要往回退的！！！
    for left:=0; left<n; left++ {
        if left > 0 {
            delete(hashSet, s[left-1]) // 每次移动左端，需要将前一个字母从HashSet中拿掉！！！
        }
        for right < n && hashSet[s[right]] == false {
            hashSet[s[right]] = true
            right++
        }
        result = max(result, right-left)
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}