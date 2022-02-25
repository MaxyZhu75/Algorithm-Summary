class Solution {
    public int maximumDifference(int[] nums) { // ̰��˼·ͬLeetCode121���Ʊ�������⣡����
        int currentMin = Integer.MAX_VALUE;
        int result = -1;
        for (int num : nums) {
            if (num > currentMin) {
                result = Math.max(result, num-currentMin);
            } else {
                currentMin = num;
            }
        }
        return result;
    }
}