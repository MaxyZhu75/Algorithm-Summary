func minimumDeletions(s string) int { // ͬLeetCode��926�⣡����
    n := len(s)
    d := [2]int{}
    if s[0] == 'a' {
        d[0], d[1] = 0, 1 // d[0]��ʾĩβԪ��Ϊʱa����С��ת����������
    } else {
        d[0], d[1] = 1, 0 // d[1]��ʾĩβԪ��Ϊbʱ����С��ת����������
    }
    for i:=1; i<n; i++ { // ����dpת�Ʒ���ֻ��ǰһ״̬�йأ��ʿɳ����Ż�������
        if s[i] == 'a' {
            d[1] = min(d[0], d[1]) + 1
        } else {
            d[1] = min(d[0], d[1])
            d[0] = d[0] + 1
        }
    }
    return min(d[0], d[1])
}

func min(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}