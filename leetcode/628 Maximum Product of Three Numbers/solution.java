class Solution {
    public int maximumProduct(int[] nums) { // ˼·Ϊ�����һ�α���ɨ�裡����
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE; // case1��������ȫ�ǷǸ�����ȫ�Ƿ�����������ӦΪ������������ˣ�����
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; // case2���������������и����������˻��ȿ�����������������ĳ˻���Ҳ������������С��������������ĳ˻�������

        for (int num : nums) { // ע�������ʼ���Լ�����ʱ���±�����if-elseд��������
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1); // ������һ�α������ҳ���������������С�����������ɣ�����max1*max2*max3��min1*min2*max1���ֽ����ʽȡ���ֵ������
    }
}