func kthFactor(n int, k int) int {// ö���Ż����������n��һ������k��������Ȼ����һ������n/k����������������������һ����С�ڵ��ڸ���n�ģ�����
    count, factor := 0, 1
    for factor*factor <= n { // ��1������n��factor������
        if n % factor == 0 {
            count++
        }
        if count == k {
            return factor
        }
        factor++
    }

    factor-- // Ҫ�㣺�˴������factor�������иô�������
    if factor*factor == n {
        factor--
    }
    
    for factor >= 1 { // �Ӹ���n��1���ر���������η��ض�Ӧ����һ������n/factor������
        if n % factor == 0 {
            count++
        }
        if count == k {
            return n / factor
        }
        factor--
    }

    return -1
}