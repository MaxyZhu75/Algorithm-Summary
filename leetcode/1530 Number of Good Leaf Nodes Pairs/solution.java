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

    public int countPairs(TreeNode root, int distance) { // 递归计算左右子树中叶子节点到公共父节点的距离！！！
        this.distance = distance;
		getDistances(root);
        return pairs;
    }

    public List<Integer> getDistances(TreeNode root) {
        List<Integer> distances = new ArrayList<Integer>();
        if (root == null) return distances; // 结点为空直接返回空列表！！！
        
		if (root.left == null && root.right == null) { // root为叶子节点！！！
            distances.add(0);
            return distances;
        }
		
        List<Integer> leftDistances = getDistances(root.left); // 递归计算左子树中各叶子节点到公共父节点root的距离；可能有多个距离故用List存储！！！
        for (int i=0; i<leftDistances.size(); i++) {
            int leftDistance = leftDistances.get(i) + 1;
            leftDistances.set(i, leftDistance);
            if (leftDistance <= distance) { // 剪枝，使得大于目标距离的值不添加入返回的结果列表！！！
                distances.add(leftDistance);
            }
        }
		
        List<Integer> rightDistances = getDistances(root.right); // 递归计算右子树中各叶子节点到公共父节点root的距离；可能有多个距离故用List存储！！！
        for (int i=0; i<rightDistances.size(); i++) {
            int rightDistance = rightDistances.get(i) + 1;
            rightDistances.set(i, rightDistance);
            if (rightDistance <= distance) { // 剪枝，使得大于目标距离的值不添加入返回的结果列表！！！
                distances.add(rightDistance);
            }
        }
		
        for (int leftDistance : leftDistances) {
            for (int rightDistance : rightDistances) {
                if (leftDistance + rightDistance <= distance) { // 统计好节点对数量！！！
                    pairs++;
                }
            }
        }
		
        return distances;
    }
}