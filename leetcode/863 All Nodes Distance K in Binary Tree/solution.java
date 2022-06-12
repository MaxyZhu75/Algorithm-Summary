/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution { // 以目标节点为起点，在二叉树中双向DFS遍历！！！
    Map<Integer, TreeNode> parents = new HashMap<>(); // 节点值唯一，故key可以使用节点值！！！
    List<Integer> result = new ArrayList<>();
	int k;
	
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
		dfsParent(root);
        dfsResult(target, null, 0);
        return result;
    }

    public void dfsParent(TreeNode node) { // DFS整棵树，用parents记录每个节点的父节点！！！
        if (node.left != null) {
            parents.put(node.left.val, node);
            dfsParent(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            dfsParent(node.right);
        }
    }

    public void dfsResult(TreeNode node, TreeNode from, int depth) { // DFS双向遍历；要点在于递归时传入来源结点「from」！！！
        if (node == null) return;
        if (depth == k) {
            result.add(node.val);
            return;
        }
        if (node.left != from) { // 左子树方向向下；不等于from即遍历路径不能逆向！！！
            dfsResult(node.left, node, depth+1);
        }
        if (node.right != from) { // 右子树方向向下！！！
            dfsResult(node.right, node, depth+1);
        }
        if (parents.get(node.val) != from) { // 父节点方向向上！！！
            dfsResult(parents.get(node.val), node, depth+1);
        }
    }
}