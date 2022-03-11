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
    public List<Integer> preorder(Node root) { // ����һ���������ݹ鷽����Go���Դ𰸣�������
        List<Integer> result = new ArrayList<>(); // ǰ������������ң�����
        if (root == null) return result;

        Stack<Node> myStack = new Stack<>(); // import java.util.Stack������������Ҫջstack������������
        myStack.push(root);

        Node currentNode = null;
        while (!myStack.isEmpty()) {
            currentNode = myStack.pop();
            result.add(currentNode.val);
            int n = currentNode.children.size();
            for (int i= n-1; i>=0; i--) { // Ҫ�㣺N�������ӽڵ�����ջ����Ҫ�������children����֮�����ӽڵ㽫�ȳ�ջ������
                Node child = currentNode.children.get(i);
                if (child != null) myStack.push(child);
            }
        }

        return result;
    }
}