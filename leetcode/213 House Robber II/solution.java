class Solution { // dp�ռ��Ż�������Go���Դ𰸣�����
    public int rob(int[] nums) { // �����ǻ���LeetCode198��Ķ�̬�滮������
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int robEntry = houseRobber(nums, 0, n-2); // case1����ѭ������ڣ�����ĩβ������
        int passEntry = houseRobber(nums, 1, n-1); // case2������ѭ������ڣ���ĩβ������
        return Math.max(robEntry, passEntry);
    }

    public int houseRobber(int[] nums, int start, int end) { // ��LeetCode198�⣬�˴���ע�⵱ʹ��ԭnums����ʱ��Ҫ��start������ʼ���ɣ���������0��������
        int n = end - start + 1;
        int d[] = new int[n+1];
        d[0] = 0;
        d[1] = nums[start];
        for (int i=2; i<n+1; i++) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[start+i-1]);
        }

        return d[n];
    }
}