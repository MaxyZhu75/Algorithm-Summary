class Solution {
    public int[] singleNumber(int[] nums) {
        int allXor = 0; // 0����������n���0^n�������Ϊn��������
        for (int num : nums) {
            allXor ^= num; // ��������n���������n^n�����Ϊ0��������Ԫ��ȫ�����Ľ������������ֻ����һ�ε����ֵ������������
        }
        int feature = allXor & (-allXor); // Ҫ�㣺������������n��λ����n&(n-1)�Ľ��Ϊn���λ��1���˴����ʾ����ֻ����һ�ε������ڶ����Ʊ�ʾ����͵Ķ��߳��ֲ�ͬ��λ������
        int group1 = 0;
        int group2 = 0;
        int[] result = new int[2];
        for (int num: nums) {
            if ((num&feature) == 0){ // ��ʱ������feature��һ��������iλ��Ϊ0��1�����������Ϊ���飬ע������ֻ����һ�ε����ֱ�Ȼ�ڲ�ͬ�飡����
                group1 ^= num; 
            } else {
                group2 ^= num;
            }
        }
        result[0] = group1; // ����ֻ����һ�ε����ָ����ڲ�ͬ�飻��������Ԫ�ؽԳ������Σ�����n���������n^n�����Ϊ0���ʸ�����������Ľ����Ϊ�𰸣�����
        result[1] = group2;
        return result;
    }
}