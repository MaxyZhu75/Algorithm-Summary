class Solution {
    public int lengthOfLongestSubstring(String s) { // 滑动窗口虫取法！！！
        Map<Character, Integer> hashRecord = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            hashRecord.put(s.charAt(right), hashRecord.getOrDefault(s.charAt(right), 0)+1);
            if (hashRecord.size() < (right-left+1)) {
                hashRecord.put(s.charAt(left), hashRecord.get(s.charAt(left))-1);
                if (hashRecord.get(s.charAt(left)) == 0) hashRecord.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return right-left;
    }
}