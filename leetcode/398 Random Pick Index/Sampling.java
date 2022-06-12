class Solution { // �������⣺ԭ����ǳ����ҳ���δ֪����ʱ��ˮ�����������ʵ�ֿռ�O(1)������
    int[] nums;
    Random random;

    public Solution(int[] nums) { // ���췽��������
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) { // ȡָ��Ԫ�ص������������������ˮ�������ȸ���֤�����ٷ���𣡣���
        int result = 0;
		int k = 0; // �������飬����k������target����ʱ���ѡ������[0,k)�ڵ�һ����������������0���򷵻�ֵ��Ϊ��Ԫ�ص��±꣬���򷵻�ֵ���䣡����
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                k++;
                if (random.nextInt(k) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */