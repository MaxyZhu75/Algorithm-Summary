class Solution {
    public int findTargetSumWays(int[] nums, int target) { // �ѵ㣺��������ת��ΪSubsetSum���⣡����
        int numsSum = sum(nums); // �����齫������Ϊ�����鸺���������ּ���P��N���������鱾��Ԫ�ؽ�Ϊ�Ǹ���������Ƶ� N-P=target���� N-(numsSum-N)=target���� N=(target+numsSum)/2������
        if (numsSum < Math.abs(target) || (numsSum + target) % 2 == 1) { // case1��ע��target����Ϊ��������
            return 0; 													 // case2��SubsetSumĿ���������Ҫ������������
        }
        int M = (numsSum + target) / 2;

        int[] d = new int[M+1];
        d[0] = 1; // basecase������
        for (int num : nums) {
            for (int j=M; j>=0; j--) {
                if (j >= num) { // dp��������Ӳ���������⣬����ͳ�ƶ����ַ���������
                    d[j] = d[j] + d[j-num]; // case1: d[i][j] = d[i-1][j] + d[i-1][j-num]������
                }							// case2: d[i][j] = d[i-1][j]������
            }
        }
        return d[M];
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}