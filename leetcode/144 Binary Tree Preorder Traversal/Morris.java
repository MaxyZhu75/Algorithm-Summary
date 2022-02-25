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
    public List<Integer> preorderTraversal(TreeNode root) { // Morris����������ʱ������ҿռ临�Ӷ�ΪO(1)������
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result; // ǰ������������ң�����

        TreeNode subtreeRoot = root, predecessor = null; // ����˼�뼴��ÿ���ڵ��������������ǣ�����Ӧ��ǰ���ڵ�predecessorָ���subtreeRoot�������Ϸ�Ϊ��Ǳ���ϸ��������̣�����Ҫ��Ϊ����;ֲ������ӽǣ�������
        
        while (subtreeRoot != null) {
            if (subtreeRoot.left != null) { // case1����߲�Ϊ��ʱ˵����δ����������Ҫ�ȶԵ�ǰ�ڵ����߰���������������Ǳ������
                
                predecessor = subtreeRoot.left; // Ҫ�㣺ʹ��whileѭ����predecessor������������У�ǰ�����Ϊ�������������ӽڵ㣡����
                while (predecessor.right != null && predecessor.right != subtreeRoot) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) { // δ���ӣ�ע��ǰ�������Ҫ�Ƚ���ǰsubtreeRoot����result���ٽ�predecessorָ��ǰsubtreeRoot��subtreeRoot�ż����������Ǳ������
                    result.add(subtreeRoot.val);
                    predecessor.right = subtreeRoot;
                    subtreeRoot = subtreeRoot.left;
                } else if (predecessor.right == subtreeRoot) { // �����ӣ�����������Ǳ�������������������ϸ����̣���Ҫ�Ͽ����ӣ����ϸ�ǰ��Ҫ�ȴ���ǰsubtreeRoot���ұߣ�����Ҫ�ֲ�����Ǳ�ϸ���������
                    predecessor.right = null;
                    subtreeRoot = subtreeRoot.right;
                }

            } else { // case2�����Ϊ�գ��򽫵�ǰsubtreeRoot�����������ұ���Ǳ������
                result.add(subtreeRoot.val);
                subtreeRoot = subtreeRoot.right;
            }
            
        }
        return result;
    }
}