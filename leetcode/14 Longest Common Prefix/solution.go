func longestCommonPrefix(strs []string) string { // 纵向按每个字符串的第i个字母比较！！！
    n := len(strs)
    for i:=0; i<len(strs[0]); i++ {
        letter := strs[0][i]
        for j:=1; j<n; j++ {
            if len(strs[j]) == i || strs[j][i] != letter { // 长度的判断在前否则会索引越界；或者直接写成两个判断！！！
                return strs[0][:i]
            }
        }
    }
    return strs[0]
}