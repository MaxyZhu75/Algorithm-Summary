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
    public List<List<Integer>> verticalTraversal(TreeNode root) { // ��LeetCode314�����ƣ�������������ͬ�Ľڵ�Ҫͨ����д���򷽷����򣡣���
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Pair<TreeNode, int[]>> bfsQueue = new ArrayDeque<>(); // Ҫ��һ��BFS��Ҫ��������ʵ�֣��˴�����PairΪ <�ڵ㣬[����������]> ������
        bfsQueue.addLast(new Pair(root, new int[]{0, 0}));

        Map<Integer, ArrayList> hashRecord = new HashMap<>(); // Ҫ�����HashMap������Map�洢��ʽΪ < ������List{[�ڵ�ֵ������]} > ������

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
                        hashRecord.put(colum, new ArrayList<int[]>()); // ��һ�γ��ָ�columʱ��Ҫ��������
                    }

                    hashRecord.get(colum).add(new int[]{currentNode.val, row}); // ���������������[�ڵ�ֵ������]����

                    bfsQueue.addLast(new Pair(currentNode.left, new int[]{row+1, colum-1})); // BFS����һ�������row��columҪ��Ӧ�Ӽ�������
                    bfsQueue.addLast(new Pair(currentNode.right, new int[]{row+1, colum+1}));
                }
            }
        }

        List<Integer> colums = new ArrayList<Integer>(hashRecord.keySet()); // ��HashMap��keySetתΪList���������򣡣���
        Collections.sort(colums);

        for (int colum : colums) {
            List<int[]> nodes = hashRecord.get(colum);
            Collections.sort(nodes, new Comparator<int[]>() { // ��ֱ�������尴colum��С�������ֲ����ڵ��row��colum����ͬ����Ҫ��Ҫ�������ټ�����������
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1]); // ��д���򷽷�����row�������У���row��ͬ�򰴽ڵ�ֵ��С�������У�����
                }
            });

            List<Integer> answer = new ArrayList<>(); // ����󽫽ڵ�ֵ���¹�����List�У�����
            for (int[] node : nodes) {
                answer.add(node[0]);
            }
            
            result.add(answer); // ����ǰ�������Ľڵ�ֵ������������
        }

        return result;
    }
}