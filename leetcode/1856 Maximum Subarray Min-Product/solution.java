public class Solution {
    public int maxSumMinProduct(int[] nums) { //「单调栈」+「正向逆向结合」+「前缀和」！！！
        int n = nums.length;
		int MOD = 1000000007;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new LinkedList<>();

        for (int i=0; i<n; i++) { //「正向」：为右边新来的元素找到左侧第一个更小的元素！！！
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // 注意默认为-1！！！
            stack.addFirst(i);
        }

        stack.clear();
        for (int i=n-1; i>=0; i--) { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            right[i] = stack.isEmpty() ? n : stack.peekFirst(); // 注意默认为n！！！
            stack.addFirst(i);
        }

        long[] pSum = new long[n+1]; // 存储前缀和！！！
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