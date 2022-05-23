class Solution {
    public String reverseWords(String s) { // �����ַ������ɱ�����ԣ���Ҫ���ַ���ת���������ɱ�����ݽṹ����StringBuilder������
        StringBuilder sb = trimSpaces(s);  // ����һ��ʵ��trim()����β�ո�ȥ�������ҽ����ʼ����ո����������
        reverse(sb, 0, sb.length() - 1);   // ���������ת�����ַ���������
        reverseEachWord(sb);               // �����������ո�����ĸ��������ڲ��Լ���ת������
        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1; // ��������ָ��ָ�룡����

        while (left <= right && s.charAt(left) == ' ') { // ȥ���ַ�����ͷ�Ŀհ��ַ�������
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') { // ȥ���ַ���ĩβ�Ŀհ��ַ�������
            right--;
        }

        StringBuilder sb = new StringBuilder(); // ע�ⷵ�ص���StringBuilder�����ַ��������Ŀհ��ַ�ȥ��������
        while (left <= right) {
            char letter = s.charAt(left);
            if (letter != ' ') {
                sb.append(letter);
            } else if (sb.charAt(sb.length() - 1) != ' ') { // ����Ƿ��������ո񣡣���
                sb.append(letter);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right)); // StringBuilder.setCharAt()������
            sb.setCharAt(right--, temp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end-1); // ���뵥�ʵĿ�ͷ��ĩβ�±꣡����
            end++;
			start = end;
        }
    }
}