func removeDuplicates(s string) string { // ͬLeetCode735������ը����Ҫʹ��ջ������
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