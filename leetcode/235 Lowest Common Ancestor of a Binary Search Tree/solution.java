/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // һ�α����ҳ����ֲ�㡹������
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) { // case1: p��q���ڵ�ǰ�ڵ��������������
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) { // case2��p��q���ڵ�ǰ�ڵ��������������
                ancestor = ancestor.right;
            } else {
                break; // case3��p��qҪô�ڵ�ǰ�ڵ�Ĳ�ͬ�������У�Ҫô����һ�����ǵ�ǰ�ڵ㣡����
            }
        }
        return ancestor;
    }
}