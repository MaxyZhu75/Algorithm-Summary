func isStrobogrammatic(num string) bool { // 双指针！！！
    hashRecord := map[byte]byte{'6':'9', '9':'6', '8':'8', '1':'1', '0':'0'} // 其他数字必不对称！！！
    left, right := 0, len(num)-1
    for left <= right { // 单个数字也要检查反转时是否正确！！！
        _, ok := hashRecord[num[left]]
        if !ok {
            return false
        }
        if hashRecord[num[left]] != num[right] { // 反转180度：整个字符串头尾颠倒，单个数字上下颠倒！！
            return false
        }
        left++
        right--
    }
    return true
}