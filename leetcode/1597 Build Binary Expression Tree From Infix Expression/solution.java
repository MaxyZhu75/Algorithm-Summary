/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public Node expTree(String s) {
        s = '(' + s + ')';
        Deque<Node> stack = new ArrayDeque<>(); // ���������˳���ȫ��ѹ��ջ������
        
		for (char letter : s.toCharArray()) {
            if (!Character.isDigit(letter) && letter != '(') { // case1:�����֡��͡������š����������Ժ�����ջ���ɣ�����
                Node previous = stack.removeFirst(); // ����ѹ��ջ���ǰ���������ҡ�������ʱջ��Ϊǰһ���������ġ������֡�������
                if (letter == '*' || letter == '/') {
                    if (stack.peekFirst().val == '*' || stack.peekFirst().val == '/') { // case2:��*���͡�/����Ҫ���ջ��ǰһ�����㣬���ҽ����ǳ˳�����Ҫ��������֮������
                        Node preOps = stack.removeFirst(); //����׼���첽�衹������
                        Node left = stack.removeFirst();
                        preOps.left = left;
                        preOps.right = previous;
                        previous = preOps;
                    }
                } else { // case3:��+���͡�-���͡������š���Ҫ���й���ֱ����ǰһ�������š�������
                    while (stack.peekFirst().val != '(') {
                        Node preOps = stack.removeFirst();
                        Node left = stack.removeFirst();
                        preOps.left = left;
                        preOps.right = previous;
                        previous = preOps;
                    }
                    if (letter == ')') { //�������š���Ҫ��һ��������ǰһ�������š��Ĳ���������
                        stack.removeFirst();
                    }
                }

                stack.addFirst(previous); // �������Ĳ��������������¡���ջ����������Ϊ��������������
            }

            if (letter != ')') { // ǰ��Ĳ��ֹ��������ջ�󡸵�ǰ�����Ż�����������֡�����ջ������
                stack.addFirst(new Node(letter));
            }
        }

        return stack.removeFirst(); // ���ʣ�¸��ڵ㷵�أ�����
    }
}