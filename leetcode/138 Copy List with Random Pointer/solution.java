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

class Solution { // ����һ���ݹ� +��ϣ������

    Map<Node, Node> hashRecord = new HashMap<>(); // �洢��ʽΪ<ԭ�ڵ㣬�����ڵ�>������

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!hashRecord.containsKey(head)) { // ��鿽���ڵ��Ƿ��Ѵ���������
            Node headCopy = new Node(head.val); // ���û�н��д����������������д���������
            hashRecord.put(head, headCopy);
            headCopy.next = copyRandomList(head.next); // �ݹ�ض�next��randomָ��ָ����д���������
            headCopy.random = copyRandomList(head.random);
        }
        return hashRecord.get(head); // ����head�Ŀ����ڵ㣡����
    }
}