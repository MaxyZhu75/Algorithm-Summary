class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        int index = 0;
        while (low <= high) { // ���ֲ����ҵ������һ�����ȱʧ���ָ�������k���Ǹ��±꡹������
            int mid = (high-low)/2 + low;
            if (missCount(nums, mid) >= k) {
                high = mid-1;
            } else {
                low = mid+1;
                index = mid;
            }
        }
        return nums[index] + (k-missCount(nums, index)); // ȷʵ���ּ�nums[index]���� k-missCount(nums, index) ������
    }

    public int missCount(int[] nums, int i) { // �ܵĿ�϶Ϊnums[i]-nums[0]-1����������Ϊi������������i-1�������ڿ�����(nums[0], nums[i])������
        return nums[i] - nums[0] - i; // ���ȱʧ����ͳ�Ʒ�����(nums[i]-nums[0]-1)-(i-1)������
    }
}