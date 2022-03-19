func isValid(s string) bool {
    myStack := []byte{} // Go语言用数组实现栈！！！
    for _, char := range s {
        letter := byte(char)
        if letter == '(' || letter == '[' || letter == '{' {
            myStack = append(myStack, letter)
        } else {
            if len(myStack) == 0 {
                return false
            }
        
            previousLeft := myStack[len(myStack)-1] // 出栈操作一：取数组最末尾的元素！！！
            myStack = myStack[:len(myStack)-1] // 出栈操作二：array[:len(array)-N]可删除数组尾部N个元素！！！
            
            check1 := (previousLeft == '(' && letter != ')')
            check2 := (previousLeft == '[' && letter != ']')
            check3 := (previousLeft == '{' && letter != '}')
            if (check1 || check2 || check3) {
                return false
            }
        }
    }
    return len(myStack) == 0
}