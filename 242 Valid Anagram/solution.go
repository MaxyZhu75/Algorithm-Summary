func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    count := make([]int, 26) // 26����ĸ����������¼������
    for _, letter := range s {
        charIndex := letter - 'a'
        count[charIndex]++ // �Ӳ���������
    }
    for _, letter := range t {
        charIndex := letter - 'a'
        count[charIndex]-- // ������������
    }
    for i:=0; i<26; i++ { // �����ַ�������ȫ��ͬʱ���������е�ֵΪ�㣡����
        if count[i] != 0 {
            return false
        }
    }

    return true
}