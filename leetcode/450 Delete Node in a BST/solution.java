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
    public TreeNode deleteNode(TreeNode root, int key) { // 分类递归！！！
        if (root == null) return null;
        
		if (root.val > key) {
            root.left = deleteNode(root.left, key); // 目标在左子树中；调用后需要直接return！！！
            return root;
        }
        
		if (root.val < key) {
            root.right = deleteNode(root.right, key); // 目标在右子树中；调用后需要直接return！！！
            return root;
        }
        
		if (root.val == key) {
            if (root.left == null && root.right == null) { // case1：目标为叶子节点，没有子树；此时可以直接将它删除，即返回空！！！
                return null;
            }
            if (root.right == null) { // case2：目标只有左子树没有右子树；此时可以将它的左子树作为新的子树，返回它的左子节点！！！
                return root.left;
            }
            if (root.left == null) { // case3：目标只有右子树没有左子树；此时可以将它的右子树作为新的子树，返回它的右子节点！！！
                return root.right;
            }
            TreeNode successor = root.right; // case4：目标有左右子树！！！
            while (successor.left != null) {
                successor = successor.left; // 后继节点：比root大的最小节点，即它的右子树中的最左节点！！！
            }
            root.right = deleteNode(root.right, successor.val); // 操作一：将successor从目标的右子树中删除；注意successor没有左子节点，递归删除时必然不会再次步入该情况！！！
            successor.right = root.right; // 操作二：将successor直接替代目标！！！
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}