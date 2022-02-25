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
    public List<Integer> inorderTraversal(TreeNode root) {  // ����һ���������ݹ鷽����Go���Դ𰸣�������
        List<Integer> result = new ArrayList<>(); // �������������ң�����
        if (root == null) return result;

        Stack<TreeNode> myStack = new Stack<>(); // import java.util.Stack������������Ҫջstack������������

        TreeNode subtreeRoot = root; // ����˼�뼴��ÿ���ڵ��������������ǣ������Ϸ�Ϊ��Ǳ���ϸ��������̣�����Ҫ��Ϊ����;ֲ������ӽǣ�������
        while (!myStack.isEmpty() || subtreeRoot != null) {
            
            while (subtreeRoot != null) { // Ҫ��һ�������������Ǳ������ͨ��һ��whileѭ�����Ƚ��������������ӽڵ�·���ϵĽڵ�ȫ����ջ��������������������
                myStack.push(subtreeRoot);
                subtreeRoot = subtreeRoot.left;
            }

            TreeNode currentNode = myStack.pop(); // Ҫ�������Ǳ���������ӽڵ���ȫ����ջ���������������ϸ����̣�����ǰpop()������������Ӧ�ȼ����������ϸ�ǰ��Ҫ�ȴ���ǰ���������ұߣ�����Ҫ�ֲ�����Ǳ�ϸ���������
            result.add(currentNode.val);
            subtreeRoot = currentNode.right; 
        } 

        return result;
    }
}