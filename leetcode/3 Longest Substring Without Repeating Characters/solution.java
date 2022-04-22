class Solution {
    public int lengthOfLongestSubstring(String s) { // 注意：字串需要连续，子序列不需要连续！！！
        int n = s.length();
        int result = 0;
        Set<Character> hashRecord = new HashSet<>(); // 记录当前窗口内已出现的字母！！！

        int right = 0; // 要点：滑动窗口的右端是不需要往回退的！！！
        for (int left=0; left<n; left++) {
            if (left > 0) hashRecord.remove(s.charAt(left-1)); // 每次移动左端，需要将前一个字母从HashSet中拿掉！！！
            while (right<n && !hashRecord.contains(s.charAt(right))) {
                hashRecord.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right-left);
        }
        return result;
    }
}