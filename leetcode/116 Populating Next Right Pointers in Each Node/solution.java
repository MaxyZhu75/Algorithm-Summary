/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) { // BFS层序遍历！！！
        if (root == null) return root;
        Deque<Node> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(root);
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                Node node = bfsQueue.pollFirst();
                if (size != 0) { // 该层末尾节点next指向null！！！
                    node.next = bfsQueue.peekFirst();
                }
                if (node.left != null) {
                    bfsQueue.addLast(node.left);
                }
                if (node.right != null) {
                    bfsQueue.addLast(node.right);
                }
            }
        }
        return root;
    }
}