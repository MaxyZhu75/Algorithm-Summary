func divide(dividend int, divisor int) int { // λ���㣻ע������߽����⣻32λ�з���������ֵ��Χ��[?2^31, 2^31?1]������
    a, b := dividend, divisor
    if a == -2147483648 && b == -1 { // ���޷�������ʾ��Χ�ܽ��Ψһ���������?2^31/-1��;����ĿҪ�󷵻� 2^31?1 ������
        return (1<<31) - 1
    }

    positive := ((a > 0) == (b > 0)) // ��Ϊ��������λ�����������¼������ţ�����
    a = abs(a)
    b = abs(b)

    result := 0
    for i:=31; i>=0; i-- { // ���ڵ�ǰa���жϳ���2^i���Ƿ���ڵ���b�����ж�2^i��b�Ƿ�С�ڵ���a������
        if (a >> i) - b >= 0 { // дΪ�����ɷ�ֹa���� 2^31 ʱ�������������
            result += (1 << i) // �����ӳ��� 2^i ������
            a -= (b << i) // ��2^i��b��a�г�ȥ������
        }
    }
    if positive {
        return result
    } else {
        return -result
    }
}

func abs(num int) int {
    if num < 0 {
        return -num
    } else {
        return num
    }
}