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
    public List<Integer> postorderTraversal(TreeNode root) { // Morris����������ʱ������ҿռ临�Ӷ�ΪO(1)������
        List<Integer> result = new ArrayList<Integer>(); // ������������Ҹ�������
        if (root == null) return result; // ����ǰ�����Ϊ�������ҡ������ǻ���ǰ�����Morris�Ĵ��룬�ԳƵ������ҵı���˳��Ϊ�������󡱣�����ٷ�ת����������ɵõ������Ҹ���������

        TreeNode subtreeRoot = root, predecessor = null; // ����˼�뼴��ÿ���ڵ��������������ǣ�����Ӧ��ǰ���ڵ�predecessorָ���subtreeRoot�������Ϸ�Ϊ��Ǳ���ϸ��������̣�����Ҫ��Ϊ����;ֲ������ӽǣ�������

        while (subtreeRoot != null) {
            if (subtreeRoot.right != null) { // case1���ұ߲�Ϊ��ʱ˵����δ����������Ҫ�ȶԵ�ǰ�ڵ���ұ߰���������������Ǳ������
                
                predecessor = subtreeRoot.right; // Ҫ�㣺ʹ��whileѭ����predecessor���ں��������ԳƷ�תʱ��ǰ�����Ϊ�������������ӽڵ㣡����
                while (predecessor.left != null && predecessor.left != subtreeRoot) {
                    predecessor = predecessor.left;
                }
                
                if (predecessor.left == null) { // δ���ӣ�ע��ǰ�������Ҫ�Ƚ���ǰsubtreeRoot����result���ٽ�predecessorָ��ǰsubtreeRoot��subtreeRoot�ż������ұ���Ǳ������
                    result.add(subtreeRoot.val);
                    predecessor.left = subtreeRoot;
                    subtreeRoot = subtreeRoot.right;
                } else if (predecessor.left == subtreeRoot) { // �����ӣ�����������Ǳ�������������������ϸ����̣���Ҫ�Ͽ����ӣ����ϸ�ǰ��Ҫ�ȴ���ǰsubtreeRoot����ߣ�����Ҫ�ֲ�����Ǳ�ϸ���������
                    predecessor.left = null;
                    subtreeRoot = subtreeRoot.left;
                }
            
            } else { // case2���ұ�Ϊ�գ��򽫵�ǰsubtreeRoot���������������Ǳ������
                result.add(subtreeRoot.val);
                subtreeRoot = subtreeRoot.left;
            }
        }

        Collections.reverse(result);
        return result;
    }
}