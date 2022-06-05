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

class BSTIterator {
    private TreeNode subtreeRoot;
    private TreeNode currentNode;
    private Deque<TreeNode> myStack;

    public BSTIterator(TreeNode root) { // 中序遍历递归解法见LeetCode第94题！！！
        this.subtreeRoot = root;
        this.myStack = new ArrayDeque<TreeNode>();
    }
    
    public int next() {
        while (subtreeRoot != null) {
            myStack.push(subtreeRoot);
            subtreeRoot = subtreeRoot.left;
        }
        currentNode = myStack.pop();
        int result = currentNode.val;
        subtreeRoot = currentNode.right;
        return result;
    }
    
    public boolean hasNext() {
        return subtreeRoot != null || !myStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */