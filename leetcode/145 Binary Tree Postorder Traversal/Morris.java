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
    public List<Integer> postorderTraversal(TreeNode root) { // Morris遍历在线性时间完成且空间复杂度为O(1)！！！
        List<Integer> result = new ArrayList<Integer>(); // 后序遍历：左右根！！！
        if (root == null) return result; // 由于前序遍历为“根左右”，我们基于前序遍历Morris的代码，对称调换左右的遍历顺序为“根右左”，最后再反转整个结果即可得到“左右根”！！！

        TreeNode subtreeRoot = root, predecessor = null; // 核心思想即将每个节点视作子树根考虑，将相应的前驱节点predecessor指向该subtreeRoot，过程上分为下潜和上浮两个过程（其中要分为总体和局部两个视角）！！！

        while (subtreeRoot != null) {
            if (subtreeRoot.right != null) { // case1：右边不为空时说明还未办手续，需要先对当前节点的右边办手续，总体上下潜！！！
                
                predecessor = subtreeRoot.right; // 要点：使用while循环找predecessor；在后续遍历对称反转时，前驱结点为右子树的最左子节点！！！
                while (predecessor.left != null && predecessor.left != subtreeRoot) {
                    predecessor = predecessor.left;
                }
                
                if (predecessor.left == null) { // 未连接：注意前序遍历需要先将当前subtreeRoot加入result；再将predecessor指向当前subtreeRoot后，subtreeRoot才继续往右边下潜！！！
                    result.add(subtreeRoot.val);
                    predecessor.left = subtreeRoot;
                    subtreeRoot = subtreeRoot.right;
                } else if (predecessor.left == subtreeRoot) { // 已连接：总体上已下潜结束，总体来看进入上浮过程，需要断开连接；但上浮前需要先处理当前subtreeRoot的左边（又需要局部的下潜上浮）！！！
                    predecessor.left = null;
                    subtreeRoot = subtreeRoot.left;
                }
            
            } else { // case2：右边为空，则将当前subtreeRoot加入结果后，向左边下潜！！！
                result.add(subtreeRoot.val);
                subtreeRoot = subtreeRoot.left;
            }
        }

        Collections.reverse(result);
        return result;
    }
}