func longestPalindrome(s string) string { // ����������չ������LeetCode647�⣡����
    start, end := 0, 0
    for i:=0; i<len(s); i++ {
        odd := expandPalindrome(s, i, i) // �������Ȼ��ģ����Ľ�һ��Ԫ�أ�����
        even := expandPalindrome(s, i, i+1) // ż�����Ȼ��ģ�����������Ԫ�أ�����
        length := max(odd, even)
        if length > end - start {
            start = i - (length-1)/2 // ����յ������ļ��㣡����
            end = i + length/2
        }
    }
    return s[start : end+1] // ע���ǡ�end+1��������
}

func expandPalindrome(s string, left int, right int) int {
    for left >= 0 && right < len(s) && s[left] == s[right] { // ��������������չ��ÿ�ɹ���չһ�ν����1����ʧ���򲻱����Ե�ǰ�����չ������
        right++
        left--
    }
    return right - left - 1
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}