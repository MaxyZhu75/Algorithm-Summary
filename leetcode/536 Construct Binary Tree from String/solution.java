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
    public TreeNode str2tree(String s) { // 递归！！！
        if(s.length() == 0) return null;
        int rootIndex = s.indexOf("(");
        if(rootIndex == -1){ // 字符串里不包含子树信息！！！
            return new TreeNode(Integer.valueOf(s));
        }
        int rootVal = Integer.parseInt(s.substring(0, rootIndex));
        TreeNode root = new TreeNode(rootVal);

        int start = rootIndex;
        int balance = 0;
        for(int i=rootIndex; i<s.length(); i++){
            if (s.charAt(i) == '(') {
			    balance++;
			} else if (s.charAt(i) == ')') {
			    balance--;
			}
            if (balance == 0 && start == rootIndex){ // case1：括号平衡；递归构造左子树！！！
                root.left = str2tree(s.substring(start+1, i));
                start = i+1; // 使得下一次扫描不要扫到「第一个左括号」即可！！！
            } else if (balance == 0 && start != rootIndex){ // case2：括号平衡且不是「第一个左括号」；递归构建右子树！！！
                root.right = str2tree(s.substring(start+1, i));
            }
        }
        return root;
    }
}