func reverseOnlyLetters(s string) string { // ˫ָ�뼴�ɣ�ע��if-else�ṹ��������ĸʱ��ǰѭ��ֻ��һ��ָ�룡����
    chars := []byte(s) // String���ɱ䣬��תΪ�ַ����飡����
    p1, p2 := 0, len(s)-1
    for p1 < p2 {
        if !(s[p1]>='a' && s[p1]<='z') && !(s[p1]>='A' && s[p1]<='Z') { // д��һ�������ַ���ֱ�ӱȽϣ�����
            p1++
        } else if !(s[p2]>='a' && s[p2]<='z') && !(s[p2]>='A' && s[p2]<='Z') {
            p2--
        } else if unicode.IsLetter(rune(s[p1])) && unicode.IsLetter(rune(s[p2])) { // д����������import "unicode"��IsLetter()������Ҫǿ��ת��Ϊ��һ���ַ�����rune��UTF-8�ַ���������
            chars[p1], chars[p2] = chars[p2], chars[p1]
            p1++
            p2--
        }
    }

    return string(chars)
}