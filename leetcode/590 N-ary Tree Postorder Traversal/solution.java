/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) { // ����һ���������ݹ鷽����Go���Դ𰸣�������
        List<Integer> result = new ArrayList<>(); // ������������Ҹ�������
        if (root == null) return result;

        Stack<Node> myStack = new Stack<>(); // Ҫ��һ��import java.util.Stack������������Ҫջstack������������
        myStack.push(root);

        Node currentNode = null;
        while (!myStack.isEmpty()) { // Ҫ������ο�LeetCode144��ǰ������������ң�����ʱ���ǽ��������ջ˳�����ӽڵ�����ջ�������˳���Ϊ�����󣡣���
            currentNode = myStack.pop();
            result.add(currentNode.val);
            for (Node child : currentNode.children) {
                if (child != null) myStack.push(child);
            }
        }

        Collections.reverse(result); // Ҫ������import java.util.Collections.reverse()�������������ת���ɱ�Ϊ���Ҹ�������
        return result;
    }
}