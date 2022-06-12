class Solution {
    public String reverseWords(String s) { // 指针遍历！！！
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int start = i; // 记录各单词第一个字母索引！！！
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            for (int k = 1; k <= i-start; k++) { // 此时i处于当前单词后的空格处！！！
                sb.append(s.charAt(i-k));
            }
            if (i < n && s.charAt(i) == ' ') { // 最后一个单词不必加空格，其余单词加空格后移动i！！！
                sb.append(' ');
                i++;
            }
        }
        return sb.toString();
    }
}