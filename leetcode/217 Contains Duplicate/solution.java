class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashRecord = new HashMap<>(); // LeetCode�ٷ����ʹ��HashSet������
        for (int num : nums) {
            if (hashRecord.containsKey(num)) {
                return true;
            } else {
                hashRecord.put(num, 1); // ���üƾ�����ִ�����ֻ���ڵ�һ�γ���ʱ��Ǵ��ڼ��ɣ��ڶ��γ��ֻ�ֱ�ӷ���true������
            }
        }
        return false;
    }
}