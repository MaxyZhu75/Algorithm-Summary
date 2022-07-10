class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>(); //��*��Ҳ��Ҫһ��ջ����Ҫ�Ƚ���*�����ɡ������š�������
        Deque<Integer> starStack = new LinkedList<>();
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !starStack.isEmpty()) { // ��Ҫ����*�����ɡ������š�����ÿ���������š������������ƥ��ġ�*��֮ǰ������
            int leftIndex = leftStack.pop();
            int starIndex = starStack.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return leftStack.isEmpty(); // �����жϡ�������ջ���Ƿ�Ϊ�գ�����
    }
}