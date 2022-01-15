class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int maxNum1 = Integer.MIN_VALUE; // java.lang.Integer�˴���ʼ����������ʹ�ã�����
        int maxNum2 = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i=0; i<n; i++) { // һ�α�������nums�����ֵ��ڶ����ֵ�Լ����ֵ���±꣡����
            if (nums[i] > maxNum1) { // case1���µ����ֵ������
                maxNum2 = maxNum1;
                maxNum1 = nums[i];
                indexMax = i;
            } else if (nums[i] > maxNum2) { // case2���µĵڶ����ֵ������
                    maxNum2 = nums[i];
            }
        }

        if (maxNum1 >= (2*maxNum2)) {
            return indexMax;
        }
        return -1;
    }
}