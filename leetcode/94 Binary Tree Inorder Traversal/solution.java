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
    public List<Integer> inorderTraversal(TreeNode root) {  // 方法一：迭代（递归方法见Go语言答案）！！！
        List<Integer> result = new ArrayList<>(); // 中序遍历：左根右！！！
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // import java.util.Stack；迭代方法需要栈stack来辅助！！！

        TreeNode subtreeRoot = root; // 核心思想即将每个节点视作子树根考虑，过程上分为下潜和上浮两个过程（其中要分为总体和局部两个视角）！！！
        while (!myStack.isEmpty() || subtreeRoot != null) {
            
            while (subtreeRoot != null) { // 要点一：优先往左边下潜，我们通过一个while循环优先将子树根到最左子节点路径上的节点全部入栈，而不急于做处理！！！
                myStack.push(subtreeRoot);
                subtreeRoot = subtreeRoot.left;
            }

            TreeNode currentNode = myStack.pop(); // 要点二：下潜结束后，左子节点已全部入栈，总体来看进入上浮过程；但当前pop()弹出的子树根应先加入结果，且上浮前需要先处理当前子树根的右边（又需要局部的下潜上浮）！！！
            result.add(currentNode.val);
            subtreeRoot = currentNode.right; 
        } 

        return result;
    }
}