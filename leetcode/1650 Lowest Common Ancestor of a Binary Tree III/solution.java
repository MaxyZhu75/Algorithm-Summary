/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) { // ����һ������һ�����и��ڵ㣡����
        List<Node> parentRecord = new ArrayList<>();
        
        while (p != null) {
            parentRecord.add(p); // �����ڵ�p�ĸ��ڵ�ʱ��Ҫ�洢������
            p = p.parent;
        }

        while(q != null) {
            if (parentRecord.contains(q)) return q; // �����ڵ�q�ĸ��ڵ㣬�鿴parentRecord���Ƿ��Ѵ洢������
            q = q.parent;
        }

        return null;
    }
}