class Solution {
    public int totalStrength(int[] strength) { //「单调栈」(解决子串最小值)+「前缀和」(解决子串之和)！！！！！！
        int MOD = 1000000007;
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 「单调栈」找最小值辐射范围写法同LeetCode907题！！！
        
        for (int i=0; i<n; i++) { // 正序处理左边界！！！
            while (!stack.isEmpty() && strength[stack.peekFirst()] > strength[i]) {
                stack.removeFirst();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peekFirst();
            }
            stack.addFirst(i);
        }

        stack.clear();
		
        for (int i=n-1; i>=0; i--) { // 逆序处理右边界！！！
            while (!stack.isEmpty() && strength[stack.peekFirst()] >= strength[i]) {
                stack.removeFirst();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peekFirst();
            }
            stack.addFirst(i);
        }

        long result = 0;
        long[] pSum = new long[n]; // 常规求前缀和；数组A[l..r]求和拆解为pSum[r]-pSum[l-1]！！！
		pSum[0] = strength[0];
        for (int i=1; i<n; i++) {
            pSum[i] = (strength[i] + pSum[i-1]) % MOD;
        }

        long[] ppSum = new long[n+1]; // 要点：最终结果累加需要复杂的排列组合；需要再次借助前缀和！！！
        for (int i=1; i<n+1; i++) {
            ppSum[i] = (pSum[i-1] + ppSum[i-1]) % MOD;
        }
        for (int i=0; i<n; i++) { // 遍历所有以strength[i]为最小值的子串，按以下方式累加结果！！！
            long leftSum = ppSum[i] - ppSum[Math.max(left[i], 0)];
            long rightSum = ppSum[right[i]] - ppSum[i];
            result = (result + strength[i] * (rightSum*(i-left[i])%MOD - leftSum*(right[i]-i)%MOD)) % MOD;
        }
        return (int) (result + MOD) % MOD;
    }
}