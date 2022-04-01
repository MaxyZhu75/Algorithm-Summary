func calculate(s string) int { // ����Stack����ɣ���ס������·������
    n := len(s)
    preOperand := '+' // ע��洢����ǰһ�������������ǵ�ǰ�ģ�����
    digit := 0 // ���������֣�����
    myStack := []int{}
    for i, letter := range s {
        isDigit := (letter >= '0') && (letter <= '9') // case1����ǰ�ַ�Ϊ���֣���ס��ͳ�����ֵĲ�������·��������
        if isDigit {
            digit = digit*10 + int(letter-'0')
        }
        if !isDigit && letter != ' ' || i == n-1 { // case2����ǰ�ַ�Ϊ�����������һλ�ַ�������
            switch preOperand { // ע��˴����ڶ�ǰһ�������������ֽ������㣡����
                case '+':
                    myStack = append(myStack, digit)
                case '-':
                    myStack = append(myStack, -digit)
                case '*':
                    myStack[len(myStack)-1] *= digit
                default:
                    myStack[len(myStack)-1] /= digit
            }
        preOperand = letter // ��ǰ��������Ϊǰһ�����������ȴ���������
        digit = 0 // ���������ֹ��㣡����
        }
    }

    result := 0
    for _, num := range myStack {
        result += num
    }
    return result
}