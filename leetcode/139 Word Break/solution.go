func wordBreak(s string, wordDict []string) bool { // ��̬�滮������
    n := len(s)
    hashRecord := make(map[string]bool)
    for _, word := range wordDict {
        hashRecord[word] = true
    }

    d := make([]bool, n+1)
    d[0] = true
    for i:=0; i<=n; i++ {
        for j:=0; j<i; j++ {
            if d[j] == true && hashRecord[s[j:i]]{ // ת�Ʒ��̣�d[i] = d[j] && check(s[j..i?1])������
                d[i] = true
                break
            }
        }
    }
    return d[n]
}