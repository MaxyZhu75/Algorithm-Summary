func reorganizeString(s string) string { // ̰�Ľ��������������ȷ��֤�����ٷ���𣡣���
    n := len(s)
    if n <= 1 {
        return s
    }

    record := make([]int, 26) // ͳ�Ƹ����ַ����ִ������������ַ������ִ���������
    maxCount := 0
    for _, c := range s {
        record[c-'a']++
        if record[c-'a'] > maxCount {
            maxCount = record[c-'a']
        }
    }

    if maxCount > (n+1)/2 { // ��n��ż����������ĸ�ĳ��ִ��������ܳ���n/2�Σ���n��������������ĸ�ĳ��ִ��������ܳ���(n+1)/2�Σ�����
        return "" // ����ż����n/2��(n+1)/2��ȣ��ʼ��ж�����������
    }

    reorganized := make([]byte, n) // ��ż�±꽻����������ʹ���ַ����飡����
    even, odd := 0, 1
    for i, count := range record {
        letter := byte('a' + i)
        for count > 0 && count <= n/2 && odd < n { // Ҫ�㣺��n��������maxCount=(n+1)/2ʱ������������ĸ����ȫ��������ż���±ꣻ����������⣡��
            reorganized[odd] = letter
            count--
            odd += 2
        }
        for count > 0 { // ��recordʣ���ַ��ó����꼴�ɣ�����
            reorganized[even] = letter
            count--
            even += 2
        }
    }
    return string(reorganized)
}