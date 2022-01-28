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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) { // 题目所给子树不为空！！！
            return false;
        }
        boolean result = false;
        boolean startFromRoot = isSubtreeFromRoot(root, subRoot);
        result = startFromRoot || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // recursion！！！
        return result;
    }

    public boolean isSubtreeFromRoot(TreeNode root, TreeNode subRoot) { // 必须从当前根节点出发，检测是否是子树！！！
        if (root == null && subRoot == null) { // case1：都为空！！！
            return true;
        }

        if (root == null || subRoot == null) { // case2：其中一个为空！！！
            return false;
        }

        boolean result = false;
        if (root.val != subRoot.val) { // case3：都不为空，比较值的大小！！！
            return false;
        } else {
            result = isSubtreeFromRoot(root.left, subRoot.left) && isSubtreeFromRoot(root.right, subRoot.right); // recursion！！！
        }
        return result;
    }
}