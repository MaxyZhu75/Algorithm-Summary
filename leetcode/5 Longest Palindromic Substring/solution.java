class Solution {
    public String longestPalindrome(String s) { // 回文中心拓展法，见LeetCode647题！！！
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            int odd = expandPalindrome(s, i, i); // 奇数长度回文，中心仅一个元素！！！
            int even = expandPalindrome(s, i, i + 1); // 偶数长度回文，中心有两个元素！！！
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len-1)/2; // 起点终点索引的计算！！！
                end = i + len/2;
            }
        }
        return s.substring(start, end+1); // 注意是「end+1」！！！
    }

    public int expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // 由中心往两边拓展，每成功拓展一次结果加1，若失败则不必再以当前起点拓展！！！
            right++;
			left--;
        }
        return right - left - 1;
    }
}