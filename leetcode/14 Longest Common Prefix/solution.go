func longestCommonPrefix(strs []string) string { // ����ÿ���ַ����ĵ�i����ĸ�Ƚϣ�����
    n := len(strs)
    for i:=0; i<len(strs[0]); i++ {
        letter := strs[0][i]
        for j:=1; j<n; j++ {
            if len(strs[j]) == i || strs[j][i] != letter { // ���ȵ��ж���ǰ���������Խ�磻����ֱ��д�������жϣ�����
                return strs[0][:i]
            }
        }
    }
    return strs[0]
}