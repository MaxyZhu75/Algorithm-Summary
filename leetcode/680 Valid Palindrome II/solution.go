func validPalindrome(s string) bool {
    var p1, p2 int = 0, len(s)-1
    for (p1 < p2) {
        if s[p1] == s[p2] { // case1�����0�ǻ��ģ���ѭ����������true������
            p1++
            p2--
        } else { // case2��������Ŀ��ʾ����ɾ��һ���ַ���������һ�β���ȣ��򻹿��Ե���isPalindrome�ж�ʣ�µĲ����Ƿ��ϸ��ǻ��ģ������ٴ�ɾ����ĸ��������
            return isPalindrome(s, p1+1, p2) || isPalindrome(s, p1, p2-1) // ɾ�����ַ������������ɾ��������һ��������ļ��ɣ��˴�ֱ��return��������������
        }
    }
    return true
}

func isPalindrome(s string, i int, j int) bool { // ������йص���Ŀ������Ҫ����÷�������Ҫ�������գ�����
    var p1, p2 int = i, j
    for (p1 < p2) {
        if s[p1] == s[p2] { // Go������string����ֱ��ʹ��S[i]�����ַ����൱��java��String.charAt()������
            p1++
            p2--
        } else {
            return false
        }
    }
    return true
}