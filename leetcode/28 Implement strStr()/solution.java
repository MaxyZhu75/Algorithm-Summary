class Solution {
    public int strStr(String haystack, String needle) { // 滑动窗口暴力解法！！！
        int n = haystack.length(), m = needle.length();
        for (int i=0; i+m <= n; i++) {
            boolean match = true;
            for (int j=0; j<m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return i;
        }
        return -1;
    }
}