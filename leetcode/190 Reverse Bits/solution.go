func reverseBits(num uint32) uint32 {
    var result uint32 = 0
    for i:=31; i>=0; i-- {
        mask := num & 1 // ����ÿ��ѭ��ĩβ�Ὣnum����һλ����˴�ÿ��ѭ����maskȡ���λ��1bit���ɣ�����
        oneBit := mask << i // �������ƽ���bit�ƶ�����Ӧλ�ã�����
        result |= oneBit // ��ӵ�����û����㣡����
        num >>= 1
    }
    return result
}