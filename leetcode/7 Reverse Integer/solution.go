func reverse(x int) int { // ��ѧ�Ƶ����ٷ���⣡����
    reverse := 0
    for x != 0 {
        if reverse < math.MinInt32 / 10 || reverse > math.MaxInt32 / 10 { // �ж�reverse�Ƿ�����[-2^31, 2^31 - 1]�ļ�����������
            return 0
        }
        digit := x % 10 // ��ת���ֵĳ��淽��������
        reverse = reverse * 10 + digit
        x /= 10
    }
    return reverse
}