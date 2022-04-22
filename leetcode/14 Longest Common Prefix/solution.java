class Solution {
    public String longestCommonPrefix(String[] strs) { // 纵向按每个字符串的第i个字母比较！！！
        int n = strs.length;
        for (int i=0; i<strs[0].length(); i++) {
            char letter = strs[0].charAt(i);
            for (int j=1; j<n; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != letter) { // 长度的判断在前否则会索引越界；或者直接写成两个判断！！！
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}