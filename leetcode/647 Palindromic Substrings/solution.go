var result int

func countSubstrings(s string) int { // ������ʹ�ô�ͳ�жϻ��ķ���isPalindrome()ʱ�临�Ӷ�Ϊn�����η���ʹ��������չ�жϻ����������̵�n��ƽ��������
    result = 0
    for i:=0; i<len(s); i++ {
        extendPalindrome(s, i, i); // �������Ȼ��ģ����Ľ�һ��Ԫ�أ�����
        extendPalindrome(s, i, i+1) // ż�����Ȼ��ģ�����������Ԫ�أ�����
    }
    return result
}

func extendPalindrome(s string, left int , right int) {
    for (left >= 0 && right < len(s) && s[left] == s[right]) { // ��������������չ��ÿ�ɹ���չһ�ν����1����ʧ���򲻱����Ե�ǰ�����չ����
        left--
        right++
        result++
    }
}