class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) { // 方法二：HashSet实现的滑动窗口！！！
        int n = nums.length;
        Set<Integer> hashWindow = new HashSet<>();
        for (int i=0; i<n; i++) {
            if (i > k) {
                hashWindow.remove(nums[i-(k+1)]); // 维持窗口大小为k+1！！！
            }
            if (hashWindow.contains(nums[i])) { // HashSet.contains()，注意集合的性质！！！
                return true;
            }
            hashWindow.add(nums[i]); // 每次循环的最后都必须把当前所指元素加入到窗口中！！！
        }
        return false;
    }
}