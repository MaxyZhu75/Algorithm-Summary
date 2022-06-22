func balancedStringSplit(s string) int { // ̰�ģ���ȷ��֤�����ٷ���⣡����
    count, balance := 0, 0
    for i:=0; i<len(s); i++ {
        if s[i] == 'L' { // L��balance++������
            balance++
        } else {
            balance-- // R��balance--������
        }
        if balance == 0 { // ̰�ĵ����ÿ��ƽ��״̬����ʱʣ�ಿ�ֱ�Ȼ����ƽ���ַ���������
            count++
        }
    }
    return count
}