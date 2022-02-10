class Solution {
    public int rob(int[] nums) { // dp�ռ��Ż�������Go���Դ𰸣�����
        int n = nums.length;
        int[] d = new int[n+1];
        d[0] = 0;
        d[1] = nums[0];
        for (int i=2; i<n+1; i++) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[i-1]); // ������dp����Ƚϼ�̣�����ע��nums�±꼴�ɣ�nums�±��dp���±꺬�岻ͳһ��������
        }

        return d[n];
    }
}