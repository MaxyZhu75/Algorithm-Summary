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
    public boolean isSubStructure(TreeNode A, TreeNode B) { // 遍历A中每个节点，A树中任一节点包含B就能返回true！！！
        return (A != null && B != null) && (recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recursion(TreeNode A, TreeNode B) { // 以A为root的树是否包含B（必须从A开始）！！！
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recursion(A.left, B.left) && recursion(A.right, B.right);
    }
}