class Solution {
    public String longestCommonPrefix(String[] strs) { // ����ÿ���ַ����ĵ�i����ĸ�Ƚϣ�����
        int n = strs.length;
        for (int i=0; i<strs[0].length(); i++) {
            char letter = strs[0].charAt(i);
            for (int j=1; j<n; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != letter) { // ���ȵ��ж���ǰ���������Խ�磻����ֱ��д�������жϣ�����
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}