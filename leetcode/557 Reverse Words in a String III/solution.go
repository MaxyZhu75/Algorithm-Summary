func reverseWords(s string) string { // 指针遍历！！！
    sb := []byte{}
    i := 0
    for i < len(s) {
        start := i // 记录各单词第一个字母索引！！！
        for i < len(s) && s[i] != ' ' {
            i++
        }
        for k:=1; k <= i-start; k++ { // 此时i处于当前单词后的空格处！！！
            sb = append(sb, s[i-k])
        }
        if i < len(s) && s[i] == ' ' { // 最后一个单词不必加空格，其余单词加空格后移动i！！！
            sb = append(sb, ' ')
            i++
        }
    }
    return string(sb)
}