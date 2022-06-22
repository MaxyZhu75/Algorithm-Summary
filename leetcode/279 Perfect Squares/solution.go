func numSquares(n int) int { // ��̬�滮����������Ǯ���⣩������
    d := make([]int, n+1)
    for i:=1; i<=n; i++ { // d[i]��ʾ������Ҫ���ٸ�����ƽ������ʾ����i������
        minPre := math.MaxInt32
        for j:=1; j*j <= i; j++ {
            minPre = min(minPre, d[i - j*j])
        }
        d[i] = minPre + 1 // ת�Ʒ��̣�d[i] = min{d[i-j^2]}+1 ������
    }
    return d[n]
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}