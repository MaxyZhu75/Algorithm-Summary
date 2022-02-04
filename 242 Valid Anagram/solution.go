func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    count := make([]int, 26) // 26个字母的数组来记录！！！
    for _, letter := range s {
        charIndex := letter - 'a'
        count[charIndex]++ // 加操作！！！
    }
    for _, letter := range t {
        charIndex := letter - 'a'
        count[charIndex]-- // 减操作！！！
    }
    for i:=0; i<26; i++ { // 仅当字符数量完全相同时，数组所有的值为零！！！
        if count[i] != 0 {
            return false
        }
    }

    return true
}