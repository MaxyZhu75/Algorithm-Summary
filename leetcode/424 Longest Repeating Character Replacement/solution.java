class Solution {
    public int characterReplacement(String s, int k) { // �������ڳ�ȡ��������
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            count[s.charAt(right)-'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right)-'A']);
            while (right-left+1 - maxCount > k) {
                count[s.charAt(left)-'A']--;
                left++;  
            }
            right++;
        }
        return right-left;
    }
}