class Solution {
    public int shipWithinDays(int[] weights, int days) { // 转化为判定问题的「二分查找」；与LeetCode第875，1231题类似！！！
        int max = 0, sum = 0;
        for (int weight : weights) {
			sum += weight;
            max = Math.max(max, weight);
		}
        int low = max, high = sum; // 起始左边界为单个货物最大重量；起始右边界为所以重量之和！！！
        while (low < high) {
            int mid = (high-low)/2 + low;
            int period = 1, currentLoad = 0; // 以mid为装载上限，period表示最少运送天数，currentLoad记录当天已运载重量！！！
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    period++;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }
            if (period <= days) { // 排除无效的装载上限，找出最小的有效装载上限！！！
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}