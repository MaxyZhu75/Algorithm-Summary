/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // ��LeetCode1650�����ƣ�����ʹ��dfs�ݹ����ֶ���¼ÿ���ڵ�ĸ��ڵ㣡����
    
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

    public void dfs(TreeNode root) { // ��������֮������ÿ���ڵ��ֵ������ͬ����˿���ֱ��ͨ��value������ڵ㣡����
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