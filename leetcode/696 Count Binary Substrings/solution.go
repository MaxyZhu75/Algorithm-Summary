func countBinarySubstrings(s string) int {
    n := len(s)
    pointer, preLen, result := 0, 0, 0 // ��preLen��ʼ��Ϊ0������

    for (pointer < n) {
        group := s[pointer] // ��ǰ�����ַ�������
        currentLen := 0
        for (pointer < n && s[pointer] == group) { // ͳ�Ƶ�ǰ�鳤�ȣ�����
            pointer++
            currentLen++
        }
        result += min(currentLen, preLen) // ���ڵ������ͬ�ַ�������resultʱ��������ĿҪ����Ӵ�����Ӧ�õ����������н϶̵ĵ���һ��ĳ��ȣ����������⣩������
        preLen = currentLen
    }

    return result
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}