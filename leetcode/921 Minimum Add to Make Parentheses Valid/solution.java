class Solution {
    public int minAddToMakeValid(String s) { // ����һ��ʹ��Deque�ӿ�ʵ��ջ������
        int left = 0;
        Deque<Character> myStack = new ArrayDeque<>(); // import java.util.Deque; import java.util.ArrayDeque������

        for (char letter : s.toCharArray()) {
            if (letter == '(') {
                myStack.push(letter);
            } else {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                } else {
                    left++;
                }
            }
        }
        return left + myStack.size(); // ��Ҫ��ӵ����������� + ��Ҫ��ӵ�����������
    }
}