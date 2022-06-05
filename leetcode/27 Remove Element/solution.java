class Solution {
    public int removeElement(int[] nums, int val) { // 双指针！！！
        int left = 0; // left左侧必是要保留的元素！！！
        int right = nums.length-1; // right右侧必是删除元素！！！
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