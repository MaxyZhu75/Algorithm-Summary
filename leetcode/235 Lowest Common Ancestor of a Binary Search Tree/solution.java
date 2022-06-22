/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // 一次遍历找出「分岔点」！！！
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) { // case1: p和q皆在当前节点的左子树！！！
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) { // case2：p和q皆在当前节点的右子树！！！
                ancestor = ancestor.right;
            } else {
                break; // case3：p和q要么在当前节点的不同的子树中，要么其中一个就是当前节点！！！
            }
        }
        return ancestor;
    }
}