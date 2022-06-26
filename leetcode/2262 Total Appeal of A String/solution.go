func appealSum(s string) int64 { // 相当于LeetCode第828题统计方法中，前一次出现的位置在本题中均为-1！！！
    d := [26]int64{}
    var result int64 = 0
    for i:=0; i<len(s); i++ {
        d[s[i]-'a'] = int64(i+1)
        for j:=0; j<26; j++ {
            result += d[j]
        }
    }
    return result
}