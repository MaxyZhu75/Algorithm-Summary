func integerBreak(n int) int {
    d := make([]int, n+1) // ����dp������
    d[0], d[1] = 0, 1 // basecase������
    for i:=2; i<=n; i++ { // ��㣺��dp��������ѭ��������
        for j:=1; j<i; j++ { // �ڲ㣺������ĳһ��ʱ��Ҫ�������п��ܵ����������
            d[i] = triMax(d[i], d[i-j]*j, (i-j)*j) // �˴�������case���������һ����©����Ϊ�ɶ����֪�˴� 0 < i-j < i����i-j����i�Ǻ���Ĳ�֣������ֲ��d[i-j]��δ����������
        }
    }
    return d[n]
}

func triMax(a int, b int, c int) int {
    if a >= b && a >= c {
        return a
    } else if b >= a && b >= c {
        return b
    } else {
        return c
    }
}