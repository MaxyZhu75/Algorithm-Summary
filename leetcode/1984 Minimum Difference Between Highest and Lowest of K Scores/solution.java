class Solution {
    public int minimumDifference(int[] nums, int k) { // 看到跟排列组合有关第一反应是回溯，但是此题排序+滑动窗口即可！！！
        int n = nums.length;
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE; // java.lang.Ingeter！！！
        for (int i=0; i<=n-k; i++) {
            int left = i;
            int right = i+k-1;
            int current = nums[right] - nums[left];
            result = Math.min(result, current);
        }

        return result; 
    }
}