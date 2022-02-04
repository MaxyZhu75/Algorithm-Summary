class Solution {
    public boolean canPartition(int[] nums) { // SubsetSum, Partition, 01Knapsack������npc����DP��˼·һ�£�����
        int N = nums.length;
        int M = 0;
        for (int num : nums) {
            M += num;
        }
        if (M % 2 == 1) {
            return false;
        } else {
            M /= 2;
        }

        boolean[] d = new boolean[M+1]; // Ҫ��һ��һά������ʽ��d[j]�ȱ�ʾd[i][j]���ֱ�ʾd[i-1][j]��ǰi����Ʒ״̬����ǰi-1����Ʒ״̬�йأ�������
        d[0] = true; // basecase������

        for (int i=0; i<N; i++) {

            int num = nums[i];
            
            for (int j=M; j>=1; j--) { // Ҫ�����һά�����ʾʱ��ѭ�������ɴ�С����Ϊ����С���󣬸���d[j]ʱ��ȡd[j-num]�Ǳ����¹��������ݣ�����
                if (j >= num) {
                    d[j] = d[j] || d[j-num]; // case1: d[i][j] = d[i-1][j] || d[i-1][j-num]������
                }                            // case2: d[i][j] = d[i-1][j]������
            }
        }

        return d[M];
    }
}