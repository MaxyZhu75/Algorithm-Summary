func trailingZeroes(n int) int { // n���׳���Ŀβ����0��2*5����������2����������5��ͳ��N�ж��ٸ�5���ɣ�����
    fives := 0 // ͬ������n�������Ʊ�ʾ�����λ1��λ�ã���ͳ��N�ж��ٸ�2������
    for (n != 0) {
        fives += n/5 // N��������5�ĸ����ɣ�N/5 + N/25 + N/125......������
        n /= 5
    }
    return fives
}