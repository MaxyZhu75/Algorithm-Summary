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
    public List<Integer> preorderTraversal(TreeNode root) { // ����һ���������ݹ鷽����Go���Դ𰸣�������
        List<Integer> result = new ArrayList<>(); // ǰ������������ң�����
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // Ҫ�㣺import java.util.Stack������������Ҫջstack������������
        myStack.push(root);

        TreeNode currentNode = null;
        while (!myStack.isEmpty()) { // ջ�Ƚ��������ջʱ���Һ�����ɱ�֤�ȴ�����ߵĽڵ㣡����
            currentNode = myStack.pop();
            result.add(currentNode.val);
            if (currentNode.right != null) myStack.push(currentNode.right);
            if (currentNode.left != null) myStack.push(currentNode.left);
        }       
        return result;
    }
}