func climbStairs(n int) int {
    if n <= 2 { // basecase��Ҫֱ�ӷ��أ���
        return n;
    }
    d := make([]int, n+1) // ����dp���������Ҳ����ֻʹ������������ѭ���ڽ��и��¼��洢���ռ临�Ӷ�ΪO(1)������
    d[1] = 1 // basecase��ֵ������
    d[2] = 2
    for i:=3; i<n+1; i++ {
        d[i] = d[i-1] + d[i-2] // ȷ��dp���̣���ѭ����dp������
    }
    return d[n]
}