class Solution {
    public int calculate(String s) { // ʹ��ջ���������
        int n = s.length();
        Deque<Integer> myStack = new ArrayDeque<>(); // ջ��Ԫ�ؼ�¼�˵�ǰλ��������ÿ������������ͬ�γɡ��ķ��ţ�����
        myStack.addFirst(1);
        int sign = 1; // ��¼��ǰ���ţ�����
        int result = 0;
        
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') { // case1�����ַ�����������
                i++;
            } else if (s.charAt(i) == '+') { // case2���Ӻţ���ȷ��ȡ��ǰ������ţ�����
                sign = myStack.peekFirst();
                i++;
            } else if (s.charAt(i) == '-') { // case3�����ţ���ȷ��ȡ��ǰ������ţ�����
                sign = -myStack.peekFirst();
                i++;
            } else if (s.charAt(i) == '(') { // case4�������ţ����������ܵ��������ѹ��ջ��������
                myStack.addFirst(sign);
                i++;
            } else if (s.charAt(i) == ')') { // case5�������ţ�������ֵ���㣬���������ܵ�������ŵ���ջ��������
                myStack.removeFirst();
                i++;
            } else { // case6�����ּ��㣡����
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // �ַ���ת���ִ�������
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}