class Solution {
    public int findMaxLength(int[] nums) { // ǰ׺�����죡����
        int n = nums.length;
        int[] pSum = new int[n+1];
        for (int i=1; i<=n; i++) { // ��Ϊ0��Ԫ�ص���-1�����Ӷ�������ת��Ϊ�������Ϊ0��������飬��pSum��ȵ���Զ�������±꣡����
		    pSum[i] = pSum[i-1] + (nums[i-1] == 1 ? 1 : -1);
		}
        int result = 0;
        Map<Integer, Integer> hashRecord = new HashMap<>(); // ��¼��ĳ��pSum�״γ��ֵ�λ�á�������
        for (int i=2; i<=n; i++) {
            if (!hashRecord.containsKey(pSum[i-2])) { // ����pSum���״γ��֣���Ϊ����࣡����
			    hashRecord.put(pSum[i-2], i-2);
			}
            if (hashRecord.containsKey(pSum[i])) { // �����״γ��֣����Ը�����Զ���룡����
			    result = Math.max(result, i-hashRecord.get(pSum[i]));
			}
        }
        return result;
    }
}