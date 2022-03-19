class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>(); // ����ƥ��ʹ��Stack������
        for (char letter : s.toCharArray()) {
            if (letter == '(' || letter == '{' || letter == '[') { // case1����������ջ������
                myStack.push(letter);
            } else { // case2�������Ž��г�ջ�������жϣ�����
                if (myStack.isEmpty()) {
                    return false;
                }
                char previousLeft = myStack.pop();
                boolean check1 = (previousLeft == '(' && letter != ')');
                boolean check2 = (previousLeft == '{' && letter != '}');
                boolean check3 = (previousLeft == '[' && letter != ']');
                if (check1 || check2 || check3) {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}