func uniqueLetterString(s string) int { // ��Ŀ������Ψһ�ַ����Ӵ�������Ҳ������Ψһ�ַ����Ӵ����ȣ������������Ӵ��У�ÿһ���Ӵ���Ψһ�ַ��ĸ����ܺͣ�����
    if len(s) == 0 {
        return 0
    }

    d := make([][]int, 26)
    for i:=0; i<26; i++ {
        d[i] = make([]int, 2) // 26����ĸ��d[char][0]��ʾ����ĸǰһ�γ��ֵ�����λ�ã�d[char][1]��ʾ����ĸ��ǰ�������ֵ�����λ�ã�����
        d[i][0] = -1
        d[i][1] = -1          // �ֶ���ʼ�����-1������
    }

    result := 0
    for i:=0; i<len(s); i++ { // �����ַ�����ÿ����ĸ��עǰһ�γ��ֵ�����λ�ã�����
        charIndex := s[i]-'A'
        d[charIndex][0] = d[charIndex][1] // ���µ�ǰĩβ��ĸdp����������ĸΨһ�Բ��䣡����
        d[charIndex][1] = i

        count := 0
        for j:=0; j<26; j++ {
            count += (d[j][1] - d[j][0]) // ����������ȷ��֤�����ٷ���𣡣���
        }
        result += count
    }

    return result % 1000000007
}