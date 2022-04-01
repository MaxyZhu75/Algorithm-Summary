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
    public List<List<Integer>> verticalTraversal(TreeNode root) { // 与LeetCode314题类似，但对于行列相同的节点要通过重写排序方法排序！！！
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Pair<TreeNode, int[]>> bfsQueue = new ArrayDeque<>(); // 要点一：BFS需要借助队列实现；此处定义Pair为 <节点，[行数，列数]> ！！！
        bfsQueue.addLast(new Pair(root, new int[]{0, 0}));

        Map<Integer, ArrayList> hashRecord = new HashMap<>(); // 要点二：HashMap拉链，Map存储方式为 < 列数，List{[节点值，行数]} > ！！！

        while (!bfsQueue.isEmpty()) {
            int nodeNum = bfsQueue.size();
            while (nodeNum-- > 0) {
                Pair<TreeNode, int[]> currentPair = bfsQueue.pollFirst();
                TreeNode currentNode = currentPair.getKey();
                int[] position = currentPair.getValue();
                int row = position[0];
                int colum = position[1];

                if (currentNode != null) {
                    if (!hashRecord.containsKey(colum)) {
                        hashRecord.put(colum, new ArrayList<int[]>()); // 第一次出现该colum时需要拉链！！
                    }

                    hashRecord.get(colum).add(new int[]{currentNode.val, row}); // 往下拉链表里添加[节点值，行数]！！

                    bfsQueue.addLast(new Pair(currentNode.left, new int[]{row+1, colum-1})); // BFS往下一层遍历，row与colum要对应加减！！！
                    bfsQueue.addLast(new Pair(currentNode.right, new int[]{row+1, colum+1}));
                }
            }
        }

        List<Integer> colums = new ArrayList<Integer>(hashRecord.keySet()); // 将HashMap的keySet转为List，方便排序！！！
        Collections.sort(colums);

        for (int colum : colums) {
            List<int[]> nodes = hashRecord.get(colum);
            Collections.sort(nodes, new Comparator<int[]>() { // 垂直遍历总体按colum由小到大处理；局部若节点的row与colum皆相同，需要按要求排序再加入结果！！！
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1]); // 重写排序方法：按row升序排列，若row相同则按节点值由小到大排列！！！
                }
            });

            List<Integer> answer = new ArrayList<>(); // 排序后将节点值重新归整入List中！！！
            for (int[] node : nodes) {
                answer.add(node[0]);
            }
            
            result.add(answer); // 将当前列排序后的节点值加入结果！！！
        }

        return result;
    }
}