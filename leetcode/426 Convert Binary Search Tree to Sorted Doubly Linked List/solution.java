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

    Node head = null; // ����ͷ�ڵ㣡����
    Node tail = null; // ����β��㣡����
    
    public Node treeToDoublyList(Node root) { // ��������ݹ���������
        if (root == null) return null;
        inorderTraversal(root);
        tail.right = head; // ѭ��������ͷ�ڵ��β�ڵ����ϣ�����
        head.left = tail;
        return head;
    }

    public void inorderTraversal(Node root) { // �������������ң�����
        if (root == null) return;
 
        inorderTraversal(root.left);
        
        if (tail == null) {
            head = root; // �״ν���ݹ�ʱ��¼rootΪͷ�ڵ㣡����
        } else {
            tail.right = root; // ˫������˫���ָ�����ӣ�����
            root.left = tail;
        }
        tail = root; // ÿ��ݹ����β�ڵ㣡����
        
        inorderTraversal(root.right);
    }
}