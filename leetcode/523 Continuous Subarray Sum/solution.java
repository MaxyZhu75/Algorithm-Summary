class Solution {
    public boolean checkSubarraySum(int[] nums, int k) { // ͬ�ඨ�� + ǰ׺�� + ��ϣ������
        int n = nums.length;
        if (n < 2) return false;
        Map<Integer, Integer> hashRecord = new HashMap<>(); // �洢ÿ��������һ�γ��ֵ��±꣡����
        hashRecord.put(0, -1);
        int remainder = 0;
        for (int i=0; i<n; i++) { // ͬ�ඨ������������� m �� n ���� n-m �ܱ� k ��������ô n �� m �� k ͬ�࣡����
            remainder = (remainder + nums[i]) % k; // �˴�������ǰ׺�͵�˼�룬���˴�����ֻ���ĵ�ǰǰ׺�Ͷ�k������������
            if (hashRecord.containsKey(remainder)) {
                int prevIndex = hashRecord.get(remainder);
                if (i - prevIndex >= 2) return true;
            } else {
                hashRecord.put(remainder, i);
            }
        }
        return false;
    }
}