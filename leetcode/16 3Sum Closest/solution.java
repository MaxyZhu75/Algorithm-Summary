class Solution {
    public int threeSumClosest(int[] nums, int target) { // ��LeetCode��15�⣡����
        int closest = 200000; // ��ʼֵ�������������㹻�󼴿ɣ�����ΪInteger.MAX_VALUE�����������
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

                if (Math.abs(sum-target) < Math.abs(closest-target)) { // ����ӽ�target��sum���и��£�����
                    closest = sum;
                }
            }
        }
        return closest;
    }
}