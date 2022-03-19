/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // 与LeetCode1650题类似，但需使用dfs递归来手动记录每个节点的父节点！！！
    
    Map<Integer, TreeNode> parentRecord = new HashMap<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> parents = new ArrayList<>();
        dfs(root);
        while (p != null) {
            parents.add(p);
            p = parentRecord.get(p.val);
        }
        while (q != null) {
            if (parents.contains(q)) return q;
            q = parentRecord.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root) { // 本题特殊之处在于每个节点的值各不相同，因此可以直接通过value来区别节点！！！
        if (root == null) return;
        if (root.left != null) {
            parentRecord.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentRecord.put(root.right.val, root);
            dfs(root.right);
        }
    }
}