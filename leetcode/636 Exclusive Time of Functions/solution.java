class Solution {
    public int[] exclusiveTime(int n, List<String> logs) { // ���̷߳���ռCPU�������������Ӻ������Ӻ�������֮�󡢸��������п��ܽ�����������ָ������������Ӻ����������е����������
        Deque<Integer> myStack = new ArrayDeque<>();
        int[] result = new int[n];
        String[] log = logs.get(0).split(":"); // ��־logs�ĸ�ʽ��ϸ����Ŀ����������
        myStack.addFirst(Integer.parseInt(log[0]));
        int previous = Integer.parseInt(log[2]); // ��¼ǰһ����־��ʱ��㣡����
        for (int i=1; i<logs.size(); i++) {
            log = logs.get(i).split(":");
            if (log[1].equals("start")) { // case1��start��ʼ����������
                if (!myStack.isEmpty()) {
                    result[myStack.peekFirst()] += (Integer.parseInt(log[2]) - previous); // �ۼӽ�ǰһ��(ջ��)�����Ľ�����У�����
				}
				myStack.addFirst(Integer.parseInt(log[0])); // ��ջ������
                previous = Integer.parseInt(log[2]);
            } else { // case2��end��������������
                result[myStack.peekFirst()] += (Integer.parseInt(log[2]) - previous + 1); // �ۼӽ�ǰһ��(ջ��)�����Ľ�����У�����
                myStack.removeFirst(); // ��ջ������
                previous = Integer.parseInt(log[2]) + 1; // ����Ŀ�������ӿ�֪������endʱ����Ҫ��1�ŷ������㣡����
            }
        }
        return result;
    }
}