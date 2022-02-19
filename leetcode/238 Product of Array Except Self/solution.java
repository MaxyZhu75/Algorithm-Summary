class Solution {
    public int[] productExceptSelf(int[] nums) { // ���ܽ��������ֵĳ˻����Ը��������������ֵõ��𰸣�����������������������ֵĳ˻����Ҳ��������ֵĳ˻�����ǰ׺���׺����˵õ��𰸣�����
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        int leftProduct = 1;
        for (int i=1; i<n; i++) { // �������ұ���һ�Σ����������н�ÿ��Ԫ��������г˻����¼��result������nums[0]�ȳ�ʼ��Ϊ1��ֻ���ұ߳˻�������ɣ�����
            leftProduct *= nums[i-1];
            result[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i=n-2; i>=0; i--) { // �����������һ�Σ����������н�ÿ��Ԫ�ص��Ҳ����г˻������result�е�������г˻������ˣ�����nums[n-1]ֻ����߳˻����ɣ�����
            rightProduct *= nums[i+1];
            result[i] *= rightProduct;
        }

        return result;
    }
}