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
    public List<List<Integer>> verticalOrder(TreeNode root) { // ��ֱ����BST������ʹ�ó���BFS������
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        
        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList(); // Ҫ��һ��BFS��Ҫ��������ʵ�֣��˴�����PairΪ <�ڵ㣬��������> ������
        bfsQueue.add(new Pair(root, 0));

        Map<Integer, ArrayList> hashRecord = new HashMap(); // Ҫ�����HashMap������colum��ͬ�Ľڵ��һ�𣡣���
        
        while (!bfsQueue.isEmpty()) {
            int nodeNum = bfsQueue.size();
            while(nodeNum-- > 0) {
                Pair<TreeNode, Integer> currentPair = bfsQueue.poll();
                TreeNode currentNode = currentPair.getKey();
                int column = currentPair.getValue();
                
				if (currentNode != null) {
                    if (!hashRecord.containsKey(column)) {
                        hashRecord.put(column, new ArrayList<Integer>()); // ��һ�γ��ָ�columʱ��Ҫ����������
                    }
                    
                    hashRecord.get(column).add(currentNode.val); // ��������������ӽڵ��ֵ������

                    bfsQueue.add(new Pair(currentNode.left, column-1)); // BFS����һ�����������Ŀ������������ң�columҲ��Ӧ��һ��һ������
                    bfsQueue.add(new Pair(currentNode.right, column+1));
                }
            }
        }

        List<Integer> colums = new ArrayList<Integer>(hashRecord.keySet()); // ��HashMap��keySetתΪList���������򣡣���
        Collections.sort(colums);
        
        for (int column : colums) {
            result.add(hashRecord.get(column)); // ��������columȥHashMap���������������ν��������result������
        }

        return result;
    }
}