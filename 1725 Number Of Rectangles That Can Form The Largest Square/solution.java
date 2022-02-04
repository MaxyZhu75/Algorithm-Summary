class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0; // 变量维护！！！
        int count = 0;

        for (int[] rectangle : rectangles) {
            int currentLen = Math.min(rectangle[0], rectangle[1]); // 必然是按矩形短边长度切正方形！！！
            if (currentLen == maxLen) {
                count++;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                count = 1;
            }
        }

        return count;
    }
}