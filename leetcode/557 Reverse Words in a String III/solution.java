class Solution {
    public String reverseWords(String s) { // ָ�����������
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int start = i; // ��¼�����ʵ�һ����ĸ����������
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            for (int k = 1; k <= i-start; k++) { // ��ʱi���ڵ�ǰ���ʺ�Ŀո񴦣�����
                sb.append(s.charAt(i-k));
            }
            if (i < n && s.charAt(i) == ' ') { // ���һ�����ʲ��ؼӿո����൥�ʼӿո���ƶ�i������
                sb.append(' ');
                i++;
            }
        }
        return sb.toString();
    }
}