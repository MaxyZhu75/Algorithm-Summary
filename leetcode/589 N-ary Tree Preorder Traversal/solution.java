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
    public List<Integer> preorder(Node root) { // 方法一：迭代（递归方法见Go语言答案）！！！
        List<Integer> result = new ArrayList<>(); // 前序遍历：根左右！！！
        if (root == null) return result;

        Stack<Node> myStack = new Stack<>(); // import java.util.Stack；迭代方法需要栈stack来辅助！！！
        myStack.push(root);

        Node currentNode = null;
        while (!myStack.isEmpty()) {
            currentNode = myStack.pop();
            result.add(currentNode.val);
            int n = currentNode.children.size();
            for (int i= n-1; i>=0; i--) { // 要点：N叉树右子节点先入栈，需要倒序遍历children；则之后左子节点将先出栈！！！
                Node child = currentNode.children.get(i);
                if (child != null) myStack.push(child);
            }
        }

        return result;
    }
}