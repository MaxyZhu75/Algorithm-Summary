class Solution {
    public int totalStrength(int[] strength) { //������ջ��(����Ӵ���Сֵ)+��ǰ׺�͡�(����Ӵ�֮��)������������
        int MOD = 1000000007;
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // ������ջ������Сֵ���䷶Χд��ͬLeetCode907�⣡����
        
        for (int i=0; i<n; i++) { // ��������߽磡����
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
		
        for (int i=n-1; i>=0; i--) { // �������ұ߽磡����
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
        long[] pSum = new long[n]; // ������ǰ׺�ͣ�����A[l..r]��Ͳ��ΪpSum[r]-pSum[l-1]������
		pSum[0] = strength[0];
        for (int i=1; i<n; i++) {
            pSum[i] = (strength[i] + pSum[i-1]) % MOD;
        }

        long[] ppSum = new long[n+1]; // Ҫ�㣺���ս���ۼ���Ҫ���ӵ�������ϣ���Ҫ�ٴν���ǰ׺�ͣ�����
        for (int i=1; i<n+1; i++) {
            ppSum[i] = (pSum[i-1] + ppSum[i-1]) % MOD;
        }
        for (int i=0; i<n; i++) { // ����������strength[i]Ϊ��Сֵ���Ӵ��������·�ʽ�ۼӽ��������
            long leftSum = ppSum[i] - ppSum[Math.max(left[i], 0)];
            long rightSum = ppSum[right[i]] - ppSum[i];
            result = (result + strength[i] * (rightSum*(i-left[i])%MOD - leftSum*(right[i]-i)%MOD)) % MOD;
        }
        return (int) (result + MOD) % MOD;
    }
}