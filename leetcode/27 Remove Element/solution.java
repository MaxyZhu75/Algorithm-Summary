class Solution {
    public int removeElement(int[] nums, int val) { // ˫ָ�룡����
        int left = 0; // left������Ҫ������Ԫ�أ�����
        int right = nums.length-1; // right�Ҳ����ɾ��Ԫ�أ�����
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}