func calculate(s string) int { // ʹ��ջ���������
    n := len(s)
    myStack := []int{1} // ջ��Ԫ�ؼ�¼�˵�ǰλ��������ÿ������������ͬ�γɡ��ķ��ţ�����
    sign, result := 1, 0 // ��¼��ǰ���ţ�����

    for i := 0; i < n; {
        if s[i] == ' ' { // case1�����ַ�����������
            i++;
        } else if s[i] == '+' {
            sign = myStack[len(myStack)-1] // case2���Ӻţ���ȷ��ȡ��ǰ������ţ�����
            i++
        } else if s[i] == '-' {
            sign = -myStack[len(myStack)-1] // case3�����ţ���ȷ��ȡ��ǰ������ţ�����
            i++
        } else if s[i] == '(' {
            myStack = append(myStack, sign) // case4�������ţ����������ܵ��������ѹ��ջ��������
            i++
        } else if s[i] == ')' {
            myStack = myStack[:len(myStack)-1] // case5�������ţ�������ֵ���㣬���������ܵ�������ŵ���ջ��������
            i++
        } else { // case6�����ּ��㣡����
            num := 0
            for i < n && s[i] >= '0' && s[i] <= '9'{ // �ַ���ת���ִ�������
                num = num * 10 + int(s[i] - '0')
                i++
            }
            result += sign * num
        }
    }
    return result
}