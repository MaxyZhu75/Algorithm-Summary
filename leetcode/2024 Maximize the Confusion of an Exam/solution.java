class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) { // 滑动窗口虫取法！！！
        int[] count = new int[2];
        int maxCount = 0;
        int left = 0, right = 0, index = 0;
        while (right < answerKey.length()) {
            index = (answerKey.charAt(right) == 'T') ? 0 : 1;
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);
            while (right-left+1 - maxCount > k) {
                index = (answerKey.charAt(left) == 'T') ? 0 : 1;
                count[index]--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}