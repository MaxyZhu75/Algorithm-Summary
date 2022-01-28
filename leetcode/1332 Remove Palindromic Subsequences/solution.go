func removePalindromeSub(s string) int {
    if isPalindrome(s, 0, len(s)-1) { // ����Ŀ�ؼ�������������壨�����У����ģ���������׾ٵؽ������ע���������У��������������У�����
        return 1
    } else {
        return 2
    }
}

func isPalindrome(s string, i int, j int) bool { // ������йص���Ŀ������Ҫ����÷�������Ҫ�������գ���
    p1, p2 := i, j
    for (p1 < p2) {
        if s[p1] == s[p2] {
            p1++
            p2--
        } else {
            return false
        }
    }
    return true
}