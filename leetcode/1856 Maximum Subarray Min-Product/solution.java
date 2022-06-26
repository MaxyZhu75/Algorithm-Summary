public class Solution {
    public int maxSumMinProduct(int[] nums) { //������ջ��+�����������ϡ�+��ǰ׺�͡�������
        int n = nums.length;
		int MOD = 1000000007;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new LinkedList<>();

        for (int i=0; i<n; i++) { //�����򡹣�Ϊ�ұ�������Ԫ���ҵ�����һ����С��Ԫ�أ�����
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // ע��Ĭ��Ϊ-1������
            stack.addFirst(i);
        }

        stack.clear();
        for (int i=n-1; i>=0; i--) { //�����򡹣�Ϊ���������Ԫ���ҵ��Ҳ��һ����С��Ԫ�أ�����
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            right[i] = stack.isEmpty() ? n : stack.peekFirst(); // ע��Ĭ��Ϊn������
            stack.addFirst(i);
        }

        long[] pSum = new long[n+1]; // �洢ǰ׺�ͣ�����
        for (int i=1; i<=n; i++) {
			pSum[i] = pSum[i-1] + nums[i-1];
		}

        long result = 0;
        for (int i=0; i<n; i++) {
            result = Math.max(result, nums[i] * (pSum[right[i]]-pSum[left[i]+1]));
        }

        return (int)(result % MOD);
    }
}