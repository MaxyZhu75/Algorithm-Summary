func wordBreak(s string, wordDict []string) bool { // 动态规划！！！
    n := len(s)
    hashRecord := make(map[string]bool)
    for _, word := range wordDict {
        hashRecord[word] = true
    }

    d := make([]bool, n+1)
    d[0] = true
    for i:=0; i<=n; i++ {
        for j:=0; j<i; j++ {
            if d[j] == true && hashRecord[s[j:i]]{ // 转移方程：d[i] = d[j] && check(s[j..i?1])！！！
                d[i] = true
                break
            }
        }
    }
    return d[n]
}