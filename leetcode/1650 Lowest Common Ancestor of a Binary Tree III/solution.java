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
    public Node lowestCommonAncestor(Node p, Node q) { // 方法一：遍历一次所有父节点！！！
        List<Node> parentRecord = new ArrayList<>();
        
        while (p != null) {
            parentRecord.add(p); // 遍历节点p的父节点时需要存储！！！
            p = p.parent;
        }

        while(q != null) {
            if (parentRecord.contains(q)) return q; // 遍历节点q的父节点，查看parentRecord里是否已存储！！！
            q = q.parent;
        }

        return null;
    }
}