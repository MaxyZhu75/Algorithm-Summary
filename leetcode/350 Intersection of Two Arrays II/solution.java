class Solution {
    public int[] intersect(int[] nums1, int[] nums2) { // ����һ����ϣ������
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); // hashRecord�洢�϶̵����飻��nums2�϶������µ��ã�����
        }
		
        Map<Integer, Integer> hashRecord = new HashMap<>();
        for (int num : nums1) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0)+1); // nums1�������������
        }
		
        int[] result = new int[nums1.length]; // ����������飬����index���������Ч���֣�����
        int index = 0;
        for (int num : nums2) {
            int count = hashRecord.getOrDefault(num, 0);
            if (count > 0) {
                count--;
                result[index++] = num;
                if (count > 0) {
                    hashRecord.put(num, count);
                } else {
                    hashRecord.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}