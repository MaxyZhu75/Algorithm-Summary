class Solution {
    public int[] searchRange(int[] nums, int target) { // ����ģʽ�Ķ��ֲ��ң����ұ߽���Ҫ��ͬ�ж�����������
        int left = partition(nums, target, 0); // ���ҵ�һ�����ڵ���target���±ꣻ��LeetCode��35�⣡����
        int right = partition(nums, target, 1) - 1; // ���ҵ�һ������target���±꣬Ȼ���ȥ1������
        if (left <= right && nums[left] == target && nums[right] == target) { // ɸѡ��Ч���������
            return new int[]{left, right};
        } 
        return new int[]{-1, -1};
    }

    public int partition(int[] nums, int target, int mode) {
        int low = 0, high = nums.length-1, result = nums.length; // ϸ�ڣ�����ʧ��ʱ���ص������鳤��n������
        while (low <= high) {
            int mid = (high-low)/2 + low;
            if (nums[mid] > target || (mode == 0 && nums[mid] >= target)) { // ���Ӷ�ģʽ���жϣ�����
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}