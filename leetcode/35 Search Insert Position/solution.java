class Solution {
    public int searchInsert(int[] nums, int target) { // �����ҵ�һ�����ڵ���target���±꣡����
        int n = nums.length;
        int low = 0, high = n-1, result = n;
        while (low <= high) {
            int mid = (high-low)/2 + low; // ϸ�ڣ�����ʧ��ʱ����������Ԫ��С��target�����ص������鳤��n������
            if (nums[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}