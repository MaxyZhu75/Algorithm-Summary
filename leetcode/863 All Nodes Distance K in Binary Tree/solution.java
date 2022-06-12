/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution { // ��Ŀ��ڵ�Ϊ��㣬�ڶ�������˫��DFS����������
    Map<Integer, TreeNode> parents = new HashMap<>(); // �ڵ�ֵΨһ����key����ʹ�ýڵ�ֵ������
    List<Integer> result = new ArrayList<>();
	int k;
	
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
		dfsParent(root);
        dfsResult(target, null, 0);
        return result;
    }

    public void dfsParent(TreeNode node) { // DFS����������parents��¼ÿ���ڵ�ĸ��ڵ㣡����
        if (node.left != null) {
            parents.put(node.left.val, node);
            dfsParent(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            dfsParent(node.right);
        }
    }

    public void dfsResult(TreeNode node, TreeNode from, int depth) { // DFS˫�������Ҫ�����ڵݹ�ʱ������Դ��㡸from��������
        if (node == null) return;
        if (depth == k) {
            result.add(node.val);
            return;
        }
        if (node.left != from) { // �������������£�������from������·���������򣡣���
            dfsResult(node.left, node, depth+1);
        }
        if (node.right != from) { // �������������£�����
            dfsResult(node.right, node, depth+1);
        }
        if (parents.get(node.val) != from) { // ���ڵ㷽�����ϣ�����
            dfsResult(parents.get(node.val), node, depth+1);
        }
    }
}