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
    public int longestUnivaluePath(TreeNode root) { // 与LeetCode543题递归结构类似！！！
        if (root == null) {
            return 0;
        }
		
		// 思路：符合要求的必经当前root节点的最长路径必由root左右两边最长路径合起来组成！！！
        int passRoot = longestOneSideFromRoot(root.left, root.val) + longestOneSideFromRoot(root.right, root.val);
		
		// 最长路径不一定过树原本的跟节点，还需要继续往下递归！！！
        int result = triMax(passRoot, longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        
        return result;
    }

    public int longestOneSideFromRoot(TreeNode current, int rootVal) { // 注意路径不能分叉，计算单边最长路径类似于dfs取最深！！！
        if (current == null || current.val != rootVal) { // 要点一：把父节点的值传入该辅助方法，则主方法会减少冗余！！！
            return 0;
        }

        int leftSide = 0;
        int rightSide = 0;
        if (current.left != null) {
            leftSide = longestOneSideFromRoot(current.left, current.val);
        }
        if (current.right != null) {
            rightSide = longestOneSideFromRoot(current.right, current.val);
        }

        int path = Math.max(leftSide, rightSide) + 1; // 要点二：当前节点与父节点值相等长度加1；由于路径不能分叉，此处必须从左右两边分开递归计算后取单边的最大与当前节点连接！！！
		
        return path;
    }

    public int triMax(int a, int b, int c) {
        if (a>=b && a>=c) {
            return a;
        } else if (b>=a && b>=c) {
            return b;
        } else {
            return c;
        }
    }

}