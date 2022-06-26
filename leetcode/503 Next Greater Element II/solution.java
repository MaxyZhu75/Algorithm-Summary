public class Solution {
    public int[] nextGreaterElements(int[] nums) { // ��ѭ�����顸��ֱ�������±�ȡģ���൱�ڽ����鸴��ƴ����β��������
        int n = nums.length;
		int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2*n - 1; i >= 0; i--) { //�����򡹣�Ϊ���������Ԫ���ҵ��Ҳ��һ����С��Ԫ�أ�����
            while (!stack.isEmpty() && nums[i%n] >= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            result[i%n] = stack.isEmpty() ? -1 : nums[stack.peekFirst()]; // ע��Ĭ��Ϊ-1������
            stack.addFirst(i%n);
        }
        return result;
    }
}