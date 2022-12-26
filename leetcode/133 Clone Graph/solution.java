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

    public Node cloneGraph(Node node) { // DFS，也可用BFS遍历！！！
        if (node == null) return node;

        if (visited.containsKey(node)) { // 若该节点已访问，则直接从哈希表中取出对应的克隆节点返回！！！
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList()); // 深拷贝的邻居列表需要new，然后递归cloneGraph()填充！！！
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode; // 返回克隆节点！！！
    }
}