func addBinary(a string, b string) string {
    p1, p2, carry := len(a)-1, len(b)-1, 0 // Ҫ��һ��ָ��Ӻ���ǰ���϶����ƴӵ�λ��ӵ�ģ�⣡����
    var result string = "" 

    for (p1 >= 0 || p2 >= 0 || carry == 1) {
        sum := carry
        if p1 >= 0 {
            sum += int(a[p1]-'0') // Go���ַ�������ȡ�����ַ�����ĸ�ַ�����Ҫ����Ӧ�ġ�0����a��������ʹ��ǿ��ת�ͣ�����
        }
        if p2 >= 0 {
            sum += int(b[p2]-'0')
        }
        carry = sum/2 // Ҫ�������������ѧ���㣡����
        result = strconv.Itoa(sum%2) + result  // ��λ = (carry+a+b)/2����ǰbit = (carrry+a+b)%2������
        p1--
        p2--
    }

    return result
}