class Solution { // ����һ�����Ե�ջ������
    public int longestValidParentheses(String s) {
        int result = 0; // ʼ�ձ���ջ��Ԫ��Ϊ��ǰ�Ѿ���������Ԫ���С����һ��û�б�ƥ��������ŵ��±꡹��ջ������Ԫ��ά���������ŵ��±꡹������
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.addFirst(-1); // ����һ��Ϊ������������ջ�����������±�����ʣ��ʱ���ǰ��ѹ��-1������ 
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') { // case1���������±�ֱ����ջ������
                stack.addFirst(i);
            } else { // case2�����������ȵ���ջ��������
                stack.removeFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i); // ��ջΪ���򽫵�ǰ����������ѹ�룻�ǿ�����¡����Ч���ŵĳ��ȡ�������
                } else {
                    result = Math.max(result, i-stack.peekFirst());
                }
            }
        }
        return result;
    }
}