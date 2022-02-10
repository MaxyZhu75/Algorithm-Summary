class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) { // 由nums1后半部分空出，可联想从后往前的双指针，则空间复杂度O(1)！！！
        int p1 = m-1;
        int p2 = n-1;
        int tail = m+n-1;

        while (p1 >= 0 || p2 >= 0) { // 该循环条件需要对应4种case！！！
            if (p1 < 0) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 < 0){
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }
    }
}