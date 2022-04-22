func minFlipsMonoIncr(s string) int { // ��̬�滮�ռ��Ż��汾������
    n := len(s)
    d := make([]int, 2)
    if s[0] == '0' { // d[0]��ʾĩβԪ��Ϊʱ0����С��ת����������
        d[0] = 0
        d[1] = 1
    } else {         // d[1]��ʾĩβԪ��Ϊ1ʱ����С��ת����������
        d[0] = 1
        d[1] = 0
    }

    for i:=1; i<n; i++ { // ����dpת�Ʒ���ֻ��ǰһ״̬�йأ��ʿɳ����Ż�������
        if s[i] == '0' {
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