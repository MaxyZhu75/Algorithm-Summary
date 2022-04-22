/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution { // 方法一：递归 +哈希表！！！

    Map<Node, Node> hashRecord = new HashMap<>(); // 存储形式为<原节点，拷贝节点>！！！

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!hashRecord.containsKey(head)) { // 检查拷贝节点是否已创建！！！
            Node headCopy = new Node(head.val); // 如果没有进行创建，则先立即进行创建！！！
            hashRecord.put(head, headCopy);
            headCopy.next = copyRandomList(head.next); // 递归地对next与random指向指针进行创建！！！
            headCopy.random = copyRandomList(head.random);
        }
        return hashRecord.get(head); // 返回head的拷贝节点！！！
    }
}