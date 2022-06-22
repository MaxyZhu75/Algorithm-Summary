class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) { // ������������������ԭ���޸ģ�����
        int n = nums.length;
        for (int num : nums) {
            int i = (num - 1) % n; // ϸ�ڣ����ڵ�ǰnum�����������k��n�������Ҫ��%n������ȷ��index������
            nums[i] += n; // ��num��ֵ��Ӧ�����������С�+n������������
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (nums[i] <= n) {
                result.add(i+1); // δ���ֹ�������Ӧ����������Ȼû����+n��������
            }
        }
        return result;
    }
}