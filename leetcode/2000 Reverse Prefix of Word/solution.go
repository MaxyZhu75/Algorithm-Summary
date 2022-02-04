func reversePrefix(word string, ch byte) string {
    stopIndex := strings.IndexByte(word, ch) // import "strings"；IndexByte(string, byte)相当于java中indexOf()！！！
    p1, p2 := 0, stopIndex
    result := []byte(word) // 相当于java中toCharArray()；string类型immutable不方便直接反转！！！
    if stopIndex == -1 || stopIndex == 0 {
        return word
    }
    for (p1 <= p2) {
        result[p1], result[p2] = result[p2], result[p1] // Go语言中byte[]类型直接交换很方便！！！
        p1++
        p2--
    }
    return string(result)
}