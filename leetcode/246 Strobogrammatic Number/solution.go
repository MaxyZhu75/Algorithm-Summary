func isStrobogrammatic(num string) bool { // ˫ָ�룡����
    hashRecord := map[byte]byte{'6':'9', '9':'6', '8':'8', '1':'1', '0':'0'} // �������ֱز��Գƣ�����
    left, right := 0, len(num)-1
    for left <= right { // ��������ҲҪ��鷴תʱ�Ƿ���ȷ������
        _, ok := hashRecord[num[left]]
        if !ok {
            return false
        }
        if hashRecord[num[left]] != num[right] { // ��ת180�ȣ������ַ���ͷβ�ߵ��������������µߵ�����
            return false
        }
        left++
        right--
    }
    return true
}