func isValid(s string) bool {
    myStack := []byte{} // Go����������ʵ��ջ������
    for _, char := range s {
        letter := byte(char)
        if letter == '(' || letter == '[' || letter == '{' {
            myStack = append(myStack, letter)
        } else {
            if len(myStack) == 0 {
                return false
            }
        
            previousLeft := myStack[len(myStack)-1] // ��ջ����һ��ȡ������ĩβ��Ԫ�أ�����
            myStack = myStack[:len(myStack)-1] // ��ջ��������array[:len(array)-N]��ɾ������β��N��Ԫ�أ�����
            
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