class Solution {
    public int minSwaps(int[] data) { // 滑动窗口！！！
        int n = data.length;
        int windowSize = 0;
        for (int i=0; i<n; i++) {
            if (data[i] == 1) windowSize++; // 滑动窗口大小 = 数组中1的总数！！！
        }

        int countOne = 0;
        for (int i=0; i<windowSize; i++) {
            if (data[i] == 1) countOne++; // 统计滑动窗口在初始位置，窗口内1的数量！！！
        }
        
        int maxOne = countOne; // 滑动窗口将向右滑动，更新记录窗口内1的最大数量！！！
        for (int i=windowSize; i<n; i++) {
            countOne += data[i]; // 入！！！
            countOne -= data[i-windowSize]; // 出！！！
            maxOne = Math.max(maxOne, countOne);
        }
        
        return windowSize-maxOne; // 需要交换的最小次数即窗口内0的最小数量！！！
    }
}