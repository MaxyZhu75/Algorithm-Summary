func multiply(num1 string, num2 string) string { // �㷨����Сѧ�˷���ʽ������򼴿ɣ�����
    m, n := len(num1), len(num2)
    digits := make([]int, m+n)
    for i:=m-1; i>=0; i-- {
        for j:=n-1; j>=0; j-- {
            p1, p2 := i+j, i+j+1
            multiply := int(num1[i] - '0') * int(num2[j] - '0') // �˴������ü���ת��Ϊ���Σ�����
            digits[p1] += (multiply + digits[p2]) / 10 // ע�⣺�˴��á�+=���ۼ�nums2��λ����Ľ��������
            digits[p2] = (multiply + digits[p2]) % 10 // �������ǵ�Ҫ����һ��Ľ�λdigits[p2]������
        }
    }
    sb := []byte{}
    for _, digit := range digits {
        if !(len(sb) == 0 && digit == 0) { // ��Ҫ��������ǰ��0������
            sb = append(sb, byte(digit + '0'))
        }
    }
    if len(sb) == 0 {
        return "0"
    } else {
        return string(sb)
    }
}