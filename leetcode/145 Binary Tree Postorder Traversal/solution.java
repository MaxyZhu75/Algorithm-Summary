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
    public List<Integer> postorderTraversal(TreeNode root) {  // ����һ���������ݹ鷽����Go���Դ𰸣�������
        List<Integer> result = new ArrayList<>(); // ������������Ҹ�������
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // Ҫ��һ��import java.util.Stack������������Ҫջstack������������
        myStack.push(root);

        TreeNode currentNode = null;
        while (!myStack.isEmpty()) { // Ҫ������ο�LeetCode144��ǰ������������ң�����ʱ���ǽ��������ջ˳�����ӽڵ�����ջ�������˳���Ϊ�����󣡣���
            currentNode = myStack.pop();
            result.add(currentNode.val);
            if (currentNode.left != null) myStack.push(currentNode.left);
            if (currentNode.right != null) myStack.push(currentNode.right); 
        }
        
        Collections.reverse(result); // Ҫ������import java.util.Collections.reverse()�������������ת���ɱ�Ϊ���Ҹ�������
        return result;
    }
}