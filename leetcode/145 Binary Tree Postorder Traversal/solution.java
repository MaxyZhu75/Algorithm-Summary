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
    public List<Integer> postorderTraversal(TreeNode root) {  // 方法一：迭代（递归方法见Go语言答案）！！！
        List<Integer> result = new ArrayList<>(); // 后序遍历：左右根！！！
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // 要点一：import java.util.Stack；迭代方法需要栈stack来辅助！！！
        myStack.push(root);

        TreeNode currentNode = null;
        while (!myStack.isEmpty()) { // 要点二：参考LeetCode144题前序遍历（根左右）；此时我们仅需调整入栈顺序，左子节点先入栈，则遍历顺序变为根右左！！！
            currentNode = myStack.pop();
            result.add(currentNode.val);
            if (currentNode.left != null) myStack.push(currentNode.left);
            if (currentNode.right != null) myStack.push(currentNode.right); 
        }
        
        Collections.reverse(result); // 要点三：import java.util.Collections.reverse()；对整个结果反转即可变为左右根！！！
        return result;
    }
}