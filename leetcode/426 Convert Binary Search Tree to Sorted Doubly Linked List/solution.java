/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    Node head = null; // 链表头节点！！！
    Node tail = null; // 链表尾结点！！！
    
    public Node treeToDoublyList(Node root) { // 中序遍历递归解决！！！
        if (root == null) return null;
        inorderTraversal(root);
        tail.right = head; // 循环链表：将头节点和尾节点连上！！！
        head.left = tail;
        return head;
    }

    public void inorderTraversal(Node root) { // 中序遍历：左根右！！！
        if (root == null) return;
 
        inorderTraversal(root.left);
        
        if (tail == null) {
            head = root; // 首次进入递归时记录root为头节点！！！
        } else {
            tail.right = root; // 双向链表：双向的指针链接！！！
            root.left = tail;
        }
        tail = root; // 每层递归更新尾节点！！！
        
        inorderTraversal(root.right);
    }
}