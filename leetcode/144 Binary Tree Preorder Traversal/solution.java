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
    public List<Integer> preorderTraversal(TreeNode root) { // 方法一：迭代（递归方法见Go语言答案）！！！
        List<Integer> result = new ArrayList<>(); // 前序遍历：根左右！！！
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // 要点：import java.util.Stack；迭代方法需要栈stack来辅助！！！
        myStack.push(root);

        TreeNode currentNode = null;
        while (!myStack.isEmpty()) { // 栈先进后出，入栈时先右后左则可保证先处理左边的节点！！！
            currentNode = myStack.pop();
            result.add(currentNode.val);
            if (currentNode.right != null) myStack.push(currentNode.right);
            if (currentNode.left != null) myStack.push(currentNode.left);
        }       
        return result;
    }
}