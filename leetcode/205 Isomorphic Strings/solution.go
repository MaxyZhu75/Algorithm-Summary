func isIsomorphic(s string, t string) bool {
    record1 := make([]int, 256) // 记录每个字符上次出现的索引！！！
    record2 := make([]int, 256) // 已知字符串由任意ASCII字符组成，大小定为128时会溢出！！！

    for i, letter1 := range s { // 已知两个字符串长度相等！！！
        letter2 := t[i]
        if record1[letter1] != record2[letter2] { // 遍历两个字符串时，若各自当前字母上次出现的索引相同则同构！！！
            return false
        }
        record1[letter1], record2[letter2] = i+1, i+1 // 数组元素初始值为0，我们把0视作该字母未出现；因此在记录出现过的字母索引时要+1以作区分（防止把第一个出现的字母索引也记录为0而出错）！！！
    }

    return true
}