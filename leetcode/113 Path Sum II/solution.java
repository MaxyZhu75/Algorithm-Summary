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
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    public void dfs(TreeNode root, int target){
        if(root == null) return;
        current.add(root.val);
        if(target-root.val == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList(current));
		}
        dfs(root.left, target-root.val);
        dfs(root.right, target-root.val);
        current.remove(current.size()-1);
    }
}