func removeDuplicates(s string) string { // 同LeetCode735题星球爆炸；需要使用栈！！！
    n := len(s)
    myStack := []byte{}
    myStack = append(myStack, s[0])

    i := 1
    for i < n {
        if len(myStack) > 0 && myStack[len(myStack)-1] == s[i] {
            myStack = myStack[:len(myStack)-1]
            i++
        } else {
            myStack = append(myStack, s[i])
            i++
        }
    }

    return string(myStack)
}