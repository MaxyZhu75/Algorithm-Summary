class Solution { // ����ջ����һ������˼ά�ķ�����LeetCode��2104�⣡����
    
	private static final int MOD = 1000000007;
    
	public int sumSubarrayMins(int[] arr) { // arr[i]�ķ��䷶Χ��һ���������飬���䷶Χ�ڲ�����������������Сֵ��Ϊarr[i]������
        int n = arr.length;
        int[] left = new int[n]; // �洢arr[i]���䷶Χ����߽磡����
        int[] right = new int[n]; // �洢arr[i]���䷶Χ���ұ߽磡����
        Deque<Integer> myStack = new ArrayDeque<>(); // ����ջ������

        for (int i=0; i<n; i++) { // ����һ����0��n-1���������õ���ջ�����ҵ���һ��С�ڵ���arr[i]���������䷶Χ����߽磡����
            while (!myStack.isEmpty() && arr[myStack.peek()] > arr[i]) {
                myStack.pop(); // ��С�ڵ���arr[i]�򵯳�ջ������
            }
            if (myStack.isEmpty()) { // ����δ�ҵ���߽���Ϊ-1������
                left[i] = -1;
            } else {
                left[i] = myStack.peek(); // �洢��߽��ֵ��������������
            }
            myStack.push(i); // ÿ��ѭ�����±���ջ������ͬʱ�õ�i��arr[i]������
        }

        myStack.clear(); // ���ջ��Ԫ�أ�����
		
        for (int i = n - 1; i >= 0; i--) { // ����һ����n-1��0���������õ���ջ�����ҵ���һ���ϸ�С��arr[i]�����������䷶Χ���ұ߽磡����
            while (!myStack.isEmpty() && arr[myStack.peek()] >= arr[i]) { // �����ұ߽��ж���������Ϊ�ϸ�С�ڣ�����Ϊ��һ������������������СֵԪ��ʱ����Ҫ���ظ��Ҳ���©��ͳ��ÿһ�������飡����
                myStack.pop(); // ���ϸ�С��arr[i]�򵯳�ջ������
            }
            if (myStack.isEmpty()) { // ����δ�ҵ��ұ߽���Ϊn������
                right[i] = n;
            } else {
                right[i] = myStack.peek(); // �洢�ұ߽��ֵ������������
            }
            myStack.push(i); // ÿ��ѭ�����±���ջ������ͬʱ�õ�i��arr[i]������
        }

        long result = 0; // ��������Ԫ��arr[i]��Ϊ��Сֵʱ�����������߽�Ӧ��[left[i],i]��ѡȡ����������ұ߽�Ӧ��[i,right[i]]��ѡȡ������
        for (int i = 0; i < n; i++) { // ������±궨���֪����Ԫ��arr[i]��Ϊ��Сֵ������������ɱ�ʾΪ(i-left)*(right-i)������
            result = (result + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)result;
    }
}