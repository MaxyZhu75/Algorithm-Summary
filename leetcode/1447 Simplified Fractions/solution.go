func simplifiedFractions(n int) []string { // ����ؼ������ж��Ƿ�Ϊ�����������ܿ���¼�ѳ��ֵ�i/j����Ϊ��/������������������������
    result := []string{}

    for i:=2; i<=n; i++ {
        for j:=1; j<i; j++ {
            if gcd(i, j) == 1 { // ��ȷ�жϷ��������ӷ�ĸ���Լ��Ϊ1����÷���Ϊ��������Ȼ���С�������������ɣ�����
                fraction := strconv.Itoa(j) + "/" + strconv.Itoa(i)
                result = append(result, fraction)
            }
        }
    }
    return result
}

func gcd(a int, b int) int { // Greatest Common Divisor�ݹ�д��������
    if b == 0 {
        return a
    } else {
        return gcd(b, a%b)
    }
}