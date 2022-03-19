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
    public List<List<Integer>> verticalOrder(TreeNode root) { // 垂直遍历BST，可以使用常规BFS！！！
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        
        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList(); // 要点一：BFS需要借助队列实现；此处定义Pair为 <节点，所在列数> ！！！
        bfsQueue.add(new Pair(root, 0));

        Map<Integer, ArrayList> hashRecord = new HashMap(); // 要点二：HashMap拉链，colum相同的节点放一起！！！
        
        while (!bfsQueue.isEmpty()) {
            int nodeNum = bfsQueue.size();
            while(nodeNum-- > 0) {
                Pair<TreeNode, Integer> currentPair = bfsQueue.poll();
                TreeNode currentNode = currentPair.getKey();
                int column = currentPair.getValue();
                
				if (currentNode != null) {
                    if (!hashRecord.containsKey(column)) {
                        hashRecord.put(column, new ArrayList<Integer>()); // 第一次出现该colum时需要拉链！！！
                    }
                    
                    hashRecord.get(column).add(currentNode.val); // 往下拉链表里添加节点的值！！！

                    bfsQueue.add(new Pair(currentNode.left, column-1)); // BFS往下一层遍历，按题目规则需先左后右，colum也对应加一减一！！！
                    bfsQueue.add(new Pair(currentNode.right, column+1));
                }
            }
        }

        List<Integer> colums = new ArrayList<Integer>(hashRecord.keySet()); // 将HashMap的keySet转为List，方便排序！！！
        Collections.sort(colums);
        
        for (int column : colums) {
            result.add(hashRecord.get(column)); // 按排序后的colum去HashMap中找下拉链表，依次将链表加入result！！！
        }

        return result;
    }
}