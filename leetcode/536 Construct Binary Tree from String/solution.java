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
    public TreeNode str2tree(String s) { // �ݹ飡����
        if(s.length() == 0) return null;
        int rootIndex = s.indexOf("(");
        if(rootIndex == -1){ // �ַ����ﲻ����������Ϣ������
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
            if (balance == 0 && start == rootIndex){ // case1������ƽ�⣻�ݹ鹹��������������
                root.left = str2tree(s.substring(start+1, i));
                start = i+1; // ʹ����һ��ɨ�費Ҫɨ������һ�������š����ɣ�����
            } else if (balance == 0 && start != rootIndex){ // case2������ƽ���Ҳ��ǡ���һ�������š����ݹ鹹��������������
                root.right = str2tree(s.substring(start+1, i));
            }
        }
        return root;
    }
}