func xorGame(nums []int) bool { // ��ѧ�����������ۡ���֤�����ٷ���𣡣���
    if len(nums) % 2 == 0 {
        return true // ����һ������A�Ļغ�ʱ�������鳤��Ϊż������A��ʤ���ڽ��۶�ǰ�����ܿ���ʹʣ�����������������Ϊ0��������
    }
    xor := 0
    for _, num := range nums {
        xor ^= num
    }
    return xor == 0 // ���۶���������ȫ��Ԫ�������Ϊ0����Aֱ��ʤ������ʤ���������֣�������
}