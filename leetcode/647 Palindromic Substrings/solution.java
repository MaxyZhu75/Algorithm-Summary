class Solution { // 该题若使用传统判断回文方法isPalindrome()时间复杂度为n的三次方；使用中心扩展判断回文则能缩短到n的平方！！！
    private int result = 0;
    
    public int countSubstrings(String s) {
        int n = s.length();
        for (int i=0; i<n; i++) {
            extendPalindrome(s, i, i); // 奇数长度回文，中心仅一个元素！！！
            extendPalindrome(s, i, i+1); // 偶数长度回文，中心有两个元素！！！
        }
        return result;
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // 由中心往两边拓展，每成功拓展一次结果加1，若失败则不必再以当前起点拓展！！！
            result++;
            left--;
            right++;
        }
    }
}