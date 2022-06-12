class Solution {
    public int minEatingSpeed(int[] piles, int h) { // 「二分查找」判断问题；与LeetCode第1011，1231题类似！！！
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int low = 1, high = max;
        while (low < high) {
            int mid = (high-low)/2 + low; // 以mid为每小时胃口上限，period表示最少吃完全部香蕉的时间！！！
            int period = 0;
            for (int pile : piles) { // 注意每小时只吃一堆；某一堆超过胃口时需要吃多个小时！！！
                if (pile > mid) {
                    period += (pile+mid-1)/mid; // 优化时间写法；此处等价于调用 Math.ceil(pile*1.0 / mid)！！！
                } else {
                    period++;
                }
            }
            if (period <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}