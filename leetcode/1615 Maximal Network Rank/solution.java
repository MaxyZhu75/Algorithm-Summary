class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
		int[] degree = new int[n]; // 存储每个节点的度！！！
        List<List<Integer>> adjacent = new ArrayList<>(); // 存储无向图，存储所有节点的邻边（即邻接表）！！！
        for (int i=0; i<n; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : roads) {
			adjacent.get(edge[1]).add(edge[0]);
			adjacent.get(edge[0]).add(edge[1]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int result = 0;
        for (int i=0; i<n; i++) { // ab的秩等于「a的邻接边数量+b的邻接边数量-(ab是否相连)」！！！
            for (int j=i+1; j<n; j++) {
                int current = degree[i] + degree[j];
                if (adjacent.get(i).contains(j) == true) {
                    current--;
                }
                result = Math.max(result, current);
            }
        }

        return result;
    }
}