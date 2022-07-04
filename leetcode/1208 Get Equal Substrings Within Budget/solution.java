class Solution {
    public int equalSubstring(String s, String t, int maxCost) { // 滑动窗口虫取法！！！
        int cost = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            cost += Math.abs(s.charAt(right)-t.charAt(right));
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++; 
            }
            right++;
        }
        return right-left;
    }
}