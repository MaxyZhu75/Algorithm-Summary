func minAddToMakeValid(s string) int { // ��������ά��balance����������
    left, balance := 0, 0
    for _, letter := range s {
        if letter == '(' {
            balance++
        } else {
            if balance > 0 {
                balance--
            } else {
                left++
                balance = 0
            }
        }
    }
    return left + balance // ��Ҫ��ӵ����������� + ��Ҫ��ӵ�����������
}