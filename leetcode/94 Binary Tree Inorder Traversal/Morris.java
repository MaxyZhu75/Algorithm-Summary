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
    public List<Integer> inorderTraversal(TreeNode root) { // Morris遍历在线性时间完成且空间复杂度为O(1)！！！
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result; // 中序遍历：左根右！！！
        
        TreeNode subtreeRoot = root, predecessor = null; // 核心思想即将每个节点视作子树根考虑，将相应的前驱节点predecessor指向该subtreeRoot，过程上分为下潜和上浮两个过程（其中要分为总体和局部两个视角）！！！

        while (subtreeRoot != null) {
            if (subtreeRoot.left != null) { // case1：左边不为空时说明还未办手续，需要先对当前节点的左边办手续，总体上下潜！！！

                predecessor = subtreeRoot.left; // 要点：使用while循环找predecessor；在中序遍历中，前驱结点为左子树的最右子节点！！！
                while (predecessor.right != null && predecessor.right != subtreeRoot) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) { // 未连接：将predecessor指向当前subtreeRoot后，subtreeRoot继续优先往左边下潜！！！
                    predecessor.right = subtreeRoot;
                    subtreeRoot = subtreeRoot.left;
                } else if (predecessor.right == subtreeRoot) { // 已连接：总体上已下潜结束，中序遍历此时才将当前subtreeRoot加入结果，总体来看进入上浮过程，需要断开连接；但上浮前需要先处理当前subtreeRoot的右边（又需要局部的下潜上浮）！！！
                    result.add(subtreeRoot.val);
                    predecessor.right = null;
                    subtreeRoot = subtreeRoot.right;
                }
            
			} else { // case2：左边为空，则将当前subtreeRoot加入结果后，向右边下潜！！！
                result.add(subtreeRoot.val);
                subtreeRoot = subtreeRoot.right;
            }
        }
        return result;
    }
}