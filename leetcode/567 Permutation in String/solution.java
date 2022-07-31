class Solution {
    public boolean checkInclusion(String s1, String s2) { // 虫取法思路！！！
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] count = new int[26];
        for (int i=0; i<n; i++) {
            count[s1.charAt(i)-'a']--;
        }
        int left = 0, right = 0;
        while (right < m) {
            count[s2.charAt(right)-'a']++;
            while (count[s2.charAt(right)-'a'] > 0) { // 不满足条件时，窗口大小不会扩张！！！
                count[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == n) { // 当窗口大小扩张到预期，就说明所有字母已经能覆盖了！！！
                return true;
            }
            right++;
        }
        return false;
    }
}