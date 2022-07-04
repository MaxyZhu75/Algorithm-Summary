class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        int[] intersection = new int[m+n];
        int index = 0, p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] == nums2[p2]) { // case1����ָԪ����ȣ�����
                if (index == 0 || nums1[p1] != intersection[index-1]) { // ��֤����Ԫ�ص�Ψһ�ԣ�����
                    intersection[index++] = nums1[p1];
                }
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) { // case2��p1��ָԪ�ظ�С������
                p1++;
            } else { // case3��p2��ָԪ�ظ�С������
                p2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index); // ֻȡ��Ч���֣�����
    }
}