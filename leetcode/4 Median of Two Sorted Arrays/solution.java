class Solution {
    int[] nums1;
	int[] nums2;
	int n1;
	int n2;
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) { // ������ֲ��ҹ����LeetCode�ٷ���𣡣���
        this.nums1 = nums1;
		this.nums2 = nums2;
		this.n1 = nums1.length;
		this.n2 = nums2.length;
        int totalLength = n1 + n2;
        if (totalLength % 2 == 1) { // �ܳ���Ϊ����ʱ��ֱ�����м�λ��Ԫ�أ�����
            int midIndex = totalLength/2;
            double median = getKthElement(midIndex + 1); // ��k=midIndex����ʱ������ת��Ϊ��ȡ��kС����������
            return median;
        } else {
            int midIndex1 = totalLength/2 - 1; // �ܳ���Ϊż��ʱ�����м�����Ԫ�صľ�ֵ������
			int midIndex2 = totalLength/2;
            double median = (getKthElement(midIndex1+1) + getKthElement(midIndex2+1)) / 2.0; // �ֱ���k1=midIndex1��k2=midIndex2����ʱ������ת��Ϊ���k1��k2С��Ԫ�أ�����
            return median;
        }
    }

    public int getKthElement(int k) {
        int left1 = 0, left2 = 0;
        while (true) {
            if (left1 == n1) { // �߽�1: nums1����������ʣ���k����nums2���Ҽ��ɣ�����
                return nums2[left2 + k - 1];
            }
            if (left2 == n2) { // �߽�2: nums2����������ʣ���k����nums1���Ҽ��ɣ�����
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]); // �߽�3�����ҽ��������ؽ�Сֵ������
            }

            int index1 = Math.min(left1 + k/2, n1) - 1; // ÿ��ȥ�Ƚ�nums1[k/2-1]��nums2[k/2-1]���ų�Ԫ�أ���k/2-1Խ�磬��ѡ���������һ��Ԫ�رȽϣ�����
            int index2 = Math.min(left2 + k/2, n2) - 1;
            if (nums1[index1] <= nums2[index2]){ // ����k�������leftָ�룡����
                k -= (index1 - left1 + 1);
                left1 = index1+1;
            } else {
                k -= (index2 - left2 + 1);
                left2 = index2+1;
            }
        }
    }
}