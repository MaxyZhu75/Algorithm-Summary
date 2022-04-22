func customSortString(order string, s string) string {
    hashRecord := make(map[byte]int)
    for _, char := range s { // ��¼s��ÿ���ַ����ִ���������
        letter := byte(char) // ��Ϊ��Ƭ�����˴���Ҫ�Ƚ�runeǿ��תΪbyte������
        _, ok := hashRecord[letter]
        if ok {
            hashRecord[letter]++
        } else {
            hashRecord[letter] = 1
        }
    }

    result := []byte{}
    for _, char := range order { // ����order����HashMap�еĴ������ν����ֵ��ַ������sb������
        letter := byte(char) // �˴���Ҫ��runeǿ��תΪbyte������
        count := hashRecord[letter]
        for count > 0 {
            count--
            result = append(result, letter)
            hashRecord[letter] = 0 // ��ӽ����������0������
        }
    }

    for letter, count := range hashRecord { // ��ʣ���ַ�ƴ�ӵ�sbĩβ�������Ҫ�󷵻��������ʵĵ��������У�������
        for count > 0 {
            count--
            result = append(result, letter)
        }
    }

    return string(result)
}