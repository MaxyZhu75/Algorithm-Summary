class Solution {
    public boolean validWordAbbreviation(String word, String abbr) { // Ҫ�㣺�����ֵĴ�������
        int n = word.length(); 
        int m = abbr.length();
        int pointer = 0; // word�е�ָ�룡����
        int digit = 0; // abbr�е����֣�����

        for (int i=0; i<m; i++) {
            char letter = abbr.charAt(i);
            if (digit == 0 && letter == '0') { // case1������ǰ��0��digit����0˵��ǰһ���ַ�������������ĸ������
                return false;                
            }

            if (letter >= '0' && letter <= '9') { // case2���������֣���������д�������˳��ͳ�ƶ�λ�������֣�����
                digit = 10 * digit  + (int)(letter-'0');
            } else { // case3��������ĸ������
                pointer += digit; // ��word��ָ���ƶ���Ȼ��digit��Ҫ���㣡����
                digit = 0;
                if (pointer >= n || word.charAt(pointer) != letter) { // ָ��Խ�����ĸ��ƥ��˵����д������ֱ�ӷ��أ�����
                    return false;
                }
                pointer++;
            }
        }
        return digit == n - pointer; // ��дĩβ�����ֲ�δ��֤����Ҫ��ѭ������֤������
    }
}