func isPalindrome(x int) bool { // Ҫ���ܽ�����ת��Ϊ�ַ���������
    if x == 0 {
        return true
    }
    if x < 0 || x % 10 == 0 { // ע���0�Ҹ�λΪ0�������ǻ�����������
        return false
    }

    right := 0
    for x > right  // Ҫ�㣺��������Ϊ���������֣���ԭʼ����С�ڻ���ڷ�ת�������ʱ������ζ�������Ѿ�������һ��λ���������ˣ�����
        right = right * 10 + x % 10
        x /= 10
    }

    return x == right || x == right / 10 // λ��Ϊ������ż��������
}