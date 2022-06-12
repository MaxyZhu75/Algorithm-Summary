class Solution {
    public String addBoldTag(String s, String[] words) { // ͬLeetCode��758�⣻�ַ��������Ӵ���ö�٣�����
        int n = s.length();
		boolean[] bold = new boolean[n];
        for (String word : words) {
            int start=0;
            while (start >= 0) { // ԭ�ַ����п��ܶ�γ���ͬһ���ʣ�����
                start = s.indexOf(word, start);
                if (start<0) break; // �����ڸõ���ʱ�᷵��-1����ֱ��break������
                int end = start + word.length();
                for (int i=start; i<end; i++) {
                    bold[i]=true;
                }
                start++; // ����һ�����֮��һ���ַ�Ϊ��㿪ʼ���ң�����
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) { // ��׷���ַ�ǰ�󣬸������������ж��Ƿ���Ҫ��ӱ�ǣ�����
            if (bold[i] && (i == 0 || !bold[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i] && (i == n-1 || !bold[i+1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}