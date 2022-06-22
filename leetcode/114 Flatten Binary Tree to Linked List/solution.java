/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public void flatten(TreeNode root) { // ·½·¨Ò»£º´æ´¢Ç°Ðò±éÀú£¡£¡£¡
        List<TreeNode> nodes = new ArrayList<>();
        preorder(root, nodes);
        for (int i=1; i<nodes.size(); i++) {
            TreeNode previous = nodes.get(i-1);
			TreeNode current = nodes.get(i);
            previous.left = null;
            previous.right = current;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> nodes) { // Ç°Ðò±éÀúµÝ¹é£¡£¡
        if (root != null) {
            nodes.add(root);
            preorder(root.left, nodes);
            preorder(root.right, nodes);
        }
    }
}