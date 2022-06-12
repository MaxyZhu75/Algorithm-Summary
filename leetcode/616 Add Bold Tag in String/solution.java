class Solution {
    public String addBoldTag(String s, String[] words) { // 同LeetCode第758题；字符串搜索子串并枚举！！！
        int n = s.length();
		boolean[] bold = new boolean[n];
        for (String word : words) {
            int start=0;
            while (start >= 0) { // 原字符串中可能多次出现同一单词！！！
                start = s.indexOf(word, start);
                if (start<0) break; // 不存在该单词时会返回-1，则直接break！！！
                int end = start + word.length();
                for (int i=start; i<end; i++) {
                    bold[i]=true;
                }
                start++; // 以上一次起点之后一个字符为起点开始查找！！！
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) { // 在追加字符前后，根据以下条件判断是否需要添加标记！！！
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