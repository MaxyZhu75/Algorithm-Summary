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
    public int rob(TreeNode root) { // 注意该题并不是简单的层序遍历求和！！！
        int[] result = valueMax(root);
        return Math.max(result[0], result[1]);
    }

    public int[] valueMax(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftNode = new int[2]; // 小偷对每个节点有两种选择，打劫或不打劫，两种情况的最大值我们都要算出，再去比较！！！
        int[] rightNode = new int[2]; // 创建数组，array[0]存储以该节点为根且该节点不被打劫所能得到的最大价值，用array[1]存储以该节点为根且该节点被打劫所能得到的最大价值！！！
        int[] containsRoot = new int[2];

        leftNode = valueMax(root.left); // 左右子节点先递归定义，再使用！！！
        rightNode = valueMax(root.right);
        containsRoot[0] = Math.max(leftNode[0], leftNode[1]) + Math.max(rightNode[0], rightNode[1]); // case1：root不被打劫，则取左右子节点各自递归结果的最大值相加即可！！！
        containsRoot[1] = leftNode[0] + rightNode[0] + root.val; // case2：root被打劫，则取root的值以及左右子节点不被打劫时所能得到的最大价值相加！！！

        return containsRoot;
    }
}