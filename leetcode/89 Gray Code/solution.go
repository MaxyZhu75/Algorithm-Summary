func grayCode(n int) []int { // �����빫ʽ������
    result := make([]int, 1<<n)
    for i:=0; i<(1<<n); i++ {
        result[i] = (i>>1) ^ i // ��ʽ:��g(i)=b(i+1)��b(i)����b(i)Ϊ��ǰ���������ĵ�i+1λ������
    }
    return result
}