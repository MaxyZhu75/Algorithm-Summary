class Solution {
    public int threeSumClosest(int[] nums, int target) { // 见LeetCode第15题！！！
        int closest = 200000; // 初始值根据条件设置足够大即可，若设为Integer.MAX_VALUE会溢出！！！
        int n = nums.length;
        Arrays.sort(nums);
        for (int p1=0; p1<n-2; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1-1]) continue;
            int left = p1 + 1;
            int right = n-1;
            while (left < right) {
                int sum = nums[p1] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    while (left < right && nums[left] == nums[++left]);
                } else {
                    while (left < right && nums[right] == nums[--right]);
                }

                if (Math.abs(sum-target) < Math.abs(closest-target)) { // 对最接近target的sum进行更新！！！
                    closest = sum;
                }
            }
        }
        return closest;
    }
}