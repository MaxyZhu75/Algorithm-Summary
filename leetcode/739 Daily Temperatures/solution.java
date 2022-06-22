class Solution {
    public int[] dailyTemperatures(int[] temperatures) { // ���䵥��ջ������
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new LinkedList<>(); //��ջ����ջ���¶����ε�����������
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) { // ԭ��ջ�ڿ����ж���¶�С�������ģ�����Ҫ��Ǻ��ջ������
                int index = stack.removeFirst();
                result[index] = i-index;
            }
            stack.addFirst(i);
        }
        return result;
    }
}