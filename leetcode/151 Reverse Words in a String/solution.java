class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();                           // ����һ��trim()���ַ�����β�ո�ȥ��������
        String[] words = s.split("\\s+");       // ��������ָ��ַ������ҽ����ʼ����ո����������
        for(int i=words.length-1; i>=0; i--) {  // ���������Ӻ���ǰ��ӵ��ʵ�sb�У�����
            sb.append(words[i]);
            if (i != 0) sb.append(' ');
        }
        return sb.toString();
    }
}