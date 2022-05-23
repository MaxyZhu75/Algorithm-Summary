class Solution { // �ռ��Ż��汾��Go�𰸣�����
    public int getMaxLen(int[] nums) { // ���ද̬�滮������
        int n = nums.length;
        int[] positive = new int[n]; // positive[i] ��ʾ��i��β���˻�Ϊ������������鳤�ȣ�����
        int[] negative = new int[n]; // negative[i] ��ʾ��i��β���˻�Ϊ������������鳤�ȣ�����
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int result = positive[0];
        for (int i=1; i<n; i++) {
            if (nums[i] > 0) { // case1��nums[i]Ϊ��������
                positive[i] = positive[i-1] + 1;
                negative[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
            } else if (nums[i] < 0) { // case2��nums[i]Ϊ��������
                positive[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
                negative[i] = positive[i-1] + 1;
            } else { // case3��nums[i]Ϊ0������
                positive[i] = 0;
                negative[i] = 0;
            }
            result = Math.max(result, positive[i]);
        }
        return result;
    }
}