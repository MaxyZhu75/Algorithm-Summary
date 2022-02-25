func isOneBitCharacter(bits []int) bool {
    n := len(bits)
    if n == 1 || bits[n-2] == 0 { // case1：数组长度为1；或结尾是00！！！
        return true
    }
    return !checkEncode(bits, n-2) // case2：结尾是10！！！
}

func checkEncode(bits []int, length int) bool { // 检查除去末尾两位的10，前面的bits能否合理编码！！！
    pointer := 0
    for (pointer < length) {
        if bits[pointer] == 0 {
            pointer++
        } else {
            pointer += 2
        }
    }
    return pointer == length
}