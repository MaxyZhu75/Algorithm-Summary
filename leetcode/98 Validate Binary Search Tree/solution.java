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
    public boolean isValidBST(TreeNode root) { // 利用性质：BST中序遍历以后得到的序列一定是升序序列；见LeetCode第94题！！！
        Deque<TreeNode> myStack = new ArrayDeque<>();
        double preVal = -Double.MAX_VALUE; // 坑点：考虑单个节点且值为最大值，则32位整数作为初值并不够！！！
        TreeNode subtreeRoot = root;
        while (!myStack.isEmpty() || subtreeRoot != null) { // 递归解法！！！
            while (subtreeRoot != null) {
                myStack.addFirst(subtreeRoot);
                subtreeRoot = subtreeRoot.left;
            }
            TreeNode currentNode = myStack.removeFirst();
            if (currentNode.val <= preVal) return false;
            preVal = currentNode.val;
            subtreeRoot = currentNode.right; 
        } 
        return true;
    }
}