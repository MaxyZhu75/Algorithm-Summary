func countBits(n int) []int {
    result := make([]int, n+1) // Go���Դ������飬�����СΪ����ʱ������ôд������
    result[0] = 0
    for i:=1; i<=n; i++{
        result[i] = result[i&(i-1)] + 1 // ���� n&(n-1) ��������n�Ķ����Ʊ��ʽ�����λ��1��ԭ�������Ƴ��ñ��ʽ������
    }
    return result
}