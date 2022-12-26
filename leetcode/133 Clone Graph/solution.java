/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) { // DFS��Ҳ����BFS����������
        if (node == null) return node;

        if (visited.containsKey(node)) { // ���ýڵ��ѷ��ʣ���ֱ�Ӵӹ�ϣ����ȡ����Ӧ�Ŀ�¡�ڵ㷵�أ�����
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList()); // ������ھ��б���Ҫnew��Ȼ��ݹ�cloneGraph()��䣡����
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode; // ���ؿ�¡�ڵ㣡����
    }
}