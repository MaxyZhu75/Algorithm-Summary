class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { //������ջ��������Ӽ���һ������Ԫ�����⡹������
        Map<Integer, Integer> hashRecord = new HashMap<>(); // ��¼��ʽ��<nums2[i], �ұ���һ�������Ԫ��ֵ>������
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=nums2.length-1; i>=0; i--) { // �������nums2������
            while (!stack.isEmpty() && stack.peekFirst() <= nums2[i]) { // ��ջ������ջ��Ԫ��С�ڵ��ڵ�ǰԪ�أ�ά������ջ��������
                stack.removeFirst();
            }
            hashRecord.put(nums2[i], stack.isEmpty() ? -1 : stack.peekFirst()); // ջΪ��˵���Ҳ�û�бȵ�ǰԪ�ظ���ģ�����
            stack.addFirst(nums2[i]); // ÿ����Ҫ��ջ����������
        }
        int[] result = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            result[i] = hashRecord.get(nums1[i]);
        }
        return result;
    }
}