class Solution { // 前缀和 + 二分查找 ！！！

    int[] prefixSum;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        prefixSum[0] = w[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i]; // 填写dp表的方式将前缀和填写完整！！！
        }
    }
    
    public int pickIndex() { // 我们已将区间[1, weightSum]看作n个部分，若此次随机选择索引为i的元素，随机数需要落在区间[prefixSum[i]-w[i]+1, prefixSum[i]]！！！
        int weightSum = prefixSum[prefixSum.length-1]; // 获取权重之和，并在[1, weightSum]中取随机数！！！
        int randomNum = (int) (Math.random() * weightSum) + 1; // java.lang.Math.random()返回 [0.0, 1.0) 的随机数！！！
        return partition(randomNum);
    }

    public int partition(int randomNum) { // 二分查找！！！
        int low = 0;
        int high = prefixSum.length-1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (prefixSum[mid] >= randomNum) { // case1：包含大于和等于两种情况，不排除mid下标！！！
                high = mid;
            } else {
                low = mid + 1; // case2：小于时，mid下标也被排除！！！
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */