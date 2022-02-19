func addStrings(num1 string, num2 string) string { // ָ��Ӻ���ǰ����ʮ���ƴӵ�λ��ӵ�ģ�⣻��LeetCode67�����ƣ�����
    p1, p2 := len(num1)-1, len(num2)-1
    carry := 0;
    var result string = ""

    for (p1 >= 0 || p2 >= 0 || carry == 1) {
        a, b := 0, 0
        if p1 >= 0 {
            a = int(num1[p1] - '0') // Go���ַ�������ȡ�����ַ�����ĸ�ַ�����Ҫ����Ӧ�ġ�0����a��������ʹ��ǿ��ת�ͣ�����
        }

        if p2 >= 0 {
            b = int(num2[p2] - '0')
        }

        sum := (a + b + carry) % 10 // ��λ = (carry+a+b)/2����ǰbit = (carrry+a+b)%2������
        carry = (a + b + carry) / 10
        result = strconv.Itoa(sum) + result
        p1--
        p2--
    }

    return result
}