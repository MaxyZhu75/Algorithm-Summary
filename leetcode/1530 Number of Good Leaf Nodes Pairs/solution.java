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
    int distance;
	int pairs = 0;

    public int countPairs(TreeNode root, int distance) { // �ݹ��������������Ҷ�ӽڵ㵽�������ڵ�ľ��룡����
        this.distance = distance;
		getDistances(root);
        return pairs;
    }

    public List<Integer> getDistances(TreeNode root) {
        List<Integer> distances = new ArrayList<Integer>();
        if (root == null) return distances; // ���Ϊ��ֱ�ӷ��ؿ��б�����
        
		if (root.left == null && root.right == null) { // rootΪҶ�ӽڵ㣡����
            distances.add(0);
            return distances;
        }
		
        List<Integer> leftDistances = getDistances(root.left); // �ݹ�����������и�Ҷ�ӽڵ㵽�������ڵ�root�ľ��룻�����ж���������List�洢������
        for (int i=0; i<leftDistances.size(); i++) {
            int leftDistance = leftDistances.get(i) + 1;
            leftDistances.set(i, leftDistance);
            if (leftDistance <= distance) { // ��֦��ʹ�ô���Ŀ������ֵ������뷵�صĽ���б�����
                distances.add(leftDistance);
            }
        }
		
        List<Integer> rightDistances = getDistances(root.right); // �ݹ�����������и�Ҷ�ӽڵ㵽�������ڵ�root�ľ��룻�����ж���������List�洢������
        for (int i=0; i<rightDistances.size(); i++) {
            int rightDistance = rightDistances.get(i) + 1;
            rightDistances.set(i, rightDistance);
            if (rightDistance <= distance) { // ��֦��ʹ�ô���Ŀ������ֵ������뷵�صĽ���б�����
                distances.add(rightDistance);
            }
        }
		
        for (int leftDistance : leftDistances) {
            for (int rightDistance : rightDistances) {
                if (leftDistance + rightDistance <= distance) { // ͳ�ƺýڵ������������
                    pairs++;
                }
            }
        }
		
        return distances;
    }
}