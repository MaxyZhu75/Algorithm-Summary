func isPalindrome(s string) bool { // ˫ָ�룻�������ռ䣡����
    s = strings.ToLower(s) // ��ȫ��תΪСд������
    left, right := 0, len(s) - 1
    for left < right {
        for left < right && !isLetterOrDigit(s[left]) { // ÿ��ѭ���Ƚ�����ָ��������ĸ������ͣ�£�����
            left++
        }
        for left < right && !isLetterOrDigit(s[right]) {
            right--
        }
        if left < right { // ������ָ��δ�ص����棬����бȽϣ�����
            if s[left] != s[right] {
                return false
            }
            left++
            right--
        }
    }
    return true
}

func isLetterOrDigit(c byte) bool { // ��дJava����Character.isLetterOrDigit()������
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
}