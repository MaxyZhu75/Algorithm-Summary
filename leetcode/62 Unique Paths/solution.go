func uniquePaths(m int, n int) int { // ��ѧ����������
    result := 1 // ��������Ͻǵ����½����ƶ�(m-1)+(n-1)�Σ���˽�����ڴ�m+n-2����ѡm-1�������ƶ�������
    x, y := n, 1
    for y < m { //��(m+n-2)!/(m-1)!(n-1)!����չ��ʽ������ڡ�(m+n-2)...(n+1)n/(m-1)!����ѭ����m-2���Σ�����
        result = (result * x) / y
        x++
        y++
    }
    return result 
}